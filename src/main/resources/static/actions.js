const token = "pk.eyJ1Ijoiamhjb25nZXIiLCJhIjoiY2t5eGhicmV3MGlqZjJ1bXc1MXdzMnlubSJ9.53Uuao-kj-NGMyyhFNJTMA"
const weathertoken = "6450ed6396197087c7e503f463ddc13e"
const FSAPI = "A4TFVB6yBQSiutacj1pDnz"

const client = filestack.init(FSAPI);
const options = {
    fromSources: ['local_file_system'],
    transformations: {
    crop: true,
        circle: true,
        rotate: true
}
}



const picker = client.picker({
    exposeOriginalFile: true,
    onFileSelected: checkImgSize,
});

// var imageHandle = ''
// var transformURL = "https://cdn.filestackcontent.com/watermark=file:";
// var watermarkHandle = '';
//
// function openPicker() {
//     console.log("open Water Picker");
//     client.pick({
//         accept: 'image/*',
//         maxFiles: 1,
//     }).then(function (result) {
//         console.log(JSON.stringify(result));
//         watermarkHandle = result.filesUploaded[0].handle;
//         console.log(watermarkHandle);
//     })
// }

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
        $(".businessImages").append("<input type='hidden' name='imageUrl' value='" + imageHandle + "'>");

    })
    json_data = {imageHandle}
    var businessImages = document.createElement("img");
    businessImages.onload = function () {
        document.getElementById("businessImages").appendChild(businessImages);
    }
    businessImages.src = imageHandle;
    function checkImgSize (file) {
        return new Promise(function (resolve, reject) {
            const maxWidth = 300;
            const maxHeight = 300;
            const blob = file.originalFile;

            // Get an object URL for the local file
            const url = URL.createObjectURL(blob);

            // Create an image and load the object URL
            const img = new Image();
            img.src = url;

            img.onload = function () {
                URL.revokeObjectURL(url);

                if (this.naturalWidth > maxWidth) {
                    reject('File is too wide');
                }

                if (this.naturalHeight > maxHeight) {
                    reject('File is too tall');
                }

                // If we made it here then the file was approved
                resolve();
            }
        });
    }
    // function buildURL() {
    //     transformURL += watermarkHandle;
    //     //Puts watermark in the center with a size 200
    //     transformURL += ',position:[middle,center],size:200/'
    //     transformURL += imageHandle;
    //     console.log(transformURL);
    // }
    //
    // function storePhoto() {
    //     console.log("storeurl");
    //     client.storeURL(transformURL).then(function (result) {
    //         console.log('Store URL');
    //         console.log(JSON.stringify(result));
    //         document.getElementById("Download Picture").href = result.url;
    //     })
    // }

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
            video.setAttribute("controls", "controls")
        }
    }
}