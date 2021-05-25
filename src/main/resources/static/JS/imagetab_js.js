var open = document.getElementById('hamburger');
var changeIcon = true;
var image = document.querySelector('.img-fluid');

async function downloadImage(imageSrc) {
    const image = await fetch(imageSrc)
    const imageBlog = await image.blob()
    const imageURL = URL.createObjectURL(imageBlog)

    const link = document.createElement('a')
    link.href = imageURL
    link.download = 'regular'
    document.body.appendChild(link)
    link.click()
    document.body.removeChild(link)
}

let download = document.querySelector('.img-fluid');
download.addEventListener('click', function() {
        console.log('1');
        // console.log(image.getAttribute('th:src'));
        // let path = image.getAttribute('src');
        // let fileName = getFileName(path);
        // saveAs(path,fileName);
    }
);

function getFileName(str){
    return str.substring(str.lastIndexOf('/') + 1);
}

open.addEventListener("click", function () {

    var overlay = document.querySelector('.overlay');
    var nav = document.querySelector('nav');
    var icon = document.querySelector('.menu-toggle i');

    overlay.classList.toggle("menu-open");
    nav.classList.toggle("menu-open");

    if (changeIcon) {
        icon.classList.remove("fa-bars");
        icon.classList.add("fa-times");

        changeIcon = false;
    } else {
        icon.classList.remove("fa-times");
        icon.classList.add("fa-bars");
        changeIcon = true;
    }
});