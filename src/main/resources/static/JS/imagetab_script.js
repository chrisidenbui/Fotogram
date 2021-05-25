var image = document.querySelector('.img-fluid');


let download = document.querySelector('.img-fluid');
download.addEventListener('click', function() {

        let path = image.getAttribute('src');
        let fileName = getFileName(path);
        saveAs(path,fileName);
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