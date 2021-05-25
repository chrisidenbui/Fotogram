
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

const heart_like = document.querySelector('.heart-icon');
let heart_click = false;
heart_like.addEventListener('click', () => {
    if (!heart_click) {
        heart_like.classList.add('liked');
        heart_click = true;
    } else {
        heart_like.classList.remove('liked');
        heart_click = false;
    }
})