const token = "pk.eyJ1Ijoiamhjb25nZXIiLCJhIjoiY2t5eGhicmV3MGlqZjJ1bXc1MXdzMnlubSJ9.53Uuao-kj-NGMyyhFNJTMA"
const weathertoken = "6450ed6396197087c7e503f463ddc13e"
const FSAPI = "A4TFVB6yBQSiutacj1pDnz"
const client = filestack.init(FSAPI);
var imageHandle = ''
var transformURL = "https://cdn.filestackcontent.com/watermark=file:";
var watermarkHandle = '';

function openPicker() {
    console.log("open Water Picker");
    client.pick({
        accept: 'image/*',
        maxFiles: 1,
    }).then(function(result) {
        console.log(JSON.stringify(result));
        watermarkHandle = result.filesUploaded[0].handle;
        console.log(watermarkHandle);
    })
}

function openPhotoPicker() {
    console.log("blah blah blah");
    console.log("open Photo Picker");
    client.pick({
        accept: 'image/*',
        maxFiles: 1,
    }).then(function (result) {
        console.log(JSON.stringify(result));
        imageHandle = result.filesUploaded[0].url;
        console.log(imageHandle);
    }).then(function () {
        $(".postImages").append("<input type='hidden' name='imageUrl' value='" + imageHandle + "'>");

    })
    json_data = {imageHandle}
    var postImages = document.createElement("img");
    postImages.onload = function() {
        document.getElementById("postImages").appendChild(postImages);
    }
    postImages.src = imageHandle;

    function buildURL() {
        transformURL += watermarkHandle;
        //Puts watermark in the center with a size 200
        transformURL += ',position:[middle,center],size:200/'
        transformURL += imageHandle;
        console.log(transformURL);
    }

    function storePhoto() {
        console.log("storeurl");
        client.storeURL(transformURL).then(function (result) {
            console.log('Store URL');
            console.log(JSON.stringify(result));
            document.getElementById("Download Picture").href = result.url;
        })
    }
    // var video = document.getElementById("myVideo");
    var btn = document.getElementById("myBtn");

    function myFunction() {
        if (video.paused) {
            video.play();
            btn.innerHTML = "Pause";
        } else {
            video.pause();
            btn.innerHTML = "Play";
        }
    }

    var video = document.getElementById("myVideo");

    function toggleControls() {
        if (video.hasAttribute("controls")) {
            video.removeAttribute("controls")
        } else {
            video.setAttribute("controls","controls")
        }
    }
// mapbox
    mapboxgl.accessToken = token;
    var accessToken = token;
    const coordinates = document.getElementById('coordinates');
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/dark-v10',
        center: [-98.4916, 29.4252],
        zoom: 8
    });
    const layerList = document.getElementById('menu');
    const inputs = layerList.getElementsByTagName('input');

    for (const input of inputs) {
        input.onclick = (layer) => {
            const layerId = layer.target.id;
            map.setStyle('mapbox://styles/mapbox/' + layerId);
        };
    }
    const nav = new mapboxgl.NavigationControl({
        showZoom: true
    });

    $(document).ready(function () {
        $('#zoom5').click(function (e) {
            map.flyTo({zoom: 5});
        });
        $(document).ready(function () {
            $('#zoom10').click(function (e) {
                map.flyTo({zoom: 10});
            });
            $(document).ready(function () {
                $('#zoom15').click(function (e) {
                    map.flyTo({zoom: 15});
                })
            });
        });
    });


    $(document).ready(function () {
        $(".removeMarkers").click(function () {
            $('svg').toggle()
        });
    });

    $.get("http://api.openweathermap.org/data/2.5/forecast", {
        APPID: weathertoken,
        lat:    29.423017,
        lon:   -98.48527,
        units: "imperial"
    }).done(function(data) {
        console.log('5 day forecast', data);
    })

    const marker = new mapboxgl.Marker({
        draggable: true
    })
        .setLngLat([-98.4916, 29.4252])
        .addTo(map);

    function onDragEnd() {
        const lngLat = marker.getLngLat();
        coordinates.style.display = 'block';
        coordinates.innerHTML = `Longitude: ${lngLat.lng}<br />Latitude: ${lngLat.lat}`;
    }

    const geocoder = new MapboxGeocoder({
        mapboxgl: mapboxgl,
        accessToken: mapboxgl.accessToken,
        marker: false
    })

    geocoder.on('result', e => {
        const marker = new mapboxgl.Marker({
            draggable: true
        })
            .setLngLat(e.result.center)
            .addTo(map)
        marker.on('dragend', function (e) {
            var lngLat = e.target.getLngLat();
            console.log(lngLat['lat'])
            console.log(lngLat['lng'])
        })
    })
    // map.addControl(geocoder)

    marker.on('dragend', function() {
        var lat = marker.getLngLat().lat
        var lng = marker.getLngLat().lng
        var currentLocation = [lat, lng]
        console.log(currentLocation);
        $('#weather').empty();
        weather(currentLocation)
    })
//search function
    $('#button').click(function(e){
        var userInput = $('#userInput').val()
        console.log(userInput);
        var searchLocation = geocode(userInput, token);
        searchLocation.then(function(coordinates){
            console.log(coordinates)
            var searchLat = coordinates[0];
            var searchLng = coordinates[1];
            var userCoordinates = [searchLat, searchLng];
            console.log(userCoordinates);
            $('#weather').empty();
            marker.setLngLat(userCoordinates);
            weather([searchLng, searchLat]);

            map.flyTo({
                center:[coordinates[0], coordinates[1]]
            })
        });
    })

    function weather(x) {
        $.ajax(`https://api.openweathermap.org/data/2.5/onecall?units=imperial&lat=${x[0]}&lon=${x[1]}&exclude=current, hourly, minutely&appID=${weathertoken}`).done(function (resp) {
            console.log(resp)

            for (var i = 0; i <= 4; i++) {
                var todayDate = new Date(resp.daily[i].dt * 1000).toDateString();
                var weatherDiv = '';
                console.log(todayDate);
                var currentTemp = resp.daily[i].temp.day.toFixed(0);
                weatherDiv += '<div class="card col-5 card-header" style="width: 18em;">' + todayDate
                weatherDiv += '<div class="list-group-item">' + "Current Temperature: " + currentTemp + '</div>'
                weatherDiv += '<div class="list-group-item">' + "Description: " + resp.daily[i].weather[0].description + '</div>'
                weatherDiv += '<div class="list-group-item">' + '<img src=http://openweathermap.org/img/w/' + resp.daily[0].weather[0].icon + '.png></div>'
                weatherDiv += '<div class="list-group-item">' + "Humidity %" + resp.daily[i].humidity + '</div>'
                weatherDiv += '<div class="list-group-item">' + "Wind Speed: " + resp.daily[i].wind_speed + '</div>'
                weatherDiv += '<div class="list-group-item">' + "Pressure: " + resp.daily[i].pressure + '</div>'
                weatherDiv += '</div>'
                weatherDiv += '</div>'


                $('#weather').append(weatherDiv);
                console.log(weatherDiv);
            }
        });
    }

    var saCoordinates = [29.4241, -98.4936];
    weather(saCoordinates);

    function geocode(search, token) {
        var baseUrl = 'https://api.mapbox.com';
        var endPoint = '/geocoding/v5/mapbox.places/';
        return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
            .then(function (res) {
                return res.json();
                // to get all the data from the request, comment out the following three lines...
            }).then(function (data) {
                return data.features[0].center;
            });
    }


}