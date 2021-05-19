var open = document.getElementById('hamburger');
var changeIcon = true;
document.addEventListener('DOMContentLoaded', () => {
    const params = (new URL(document.location)).searchParams;
    let image_src = document.location.search.replace(/^.*?\=/,'')
    let main_image = document.querySelector('.image_tab > img');
    main_image.src = image_src
})

open.addEventListener("click", function(){

    var overlay = document.querySelector('.overlay');
    var nav = document.querySelector('nav');
    var icon = document.querySelector('.menu-toggle i');

    overlay.classList.toggle("menu-open");
    nav.classList.toggle("menu-open");

    if (changeIcon) {
        icon.classList.remove("fa-bars");
        icon.classList.add("fa-times");

        changeIcon = false;
    }
    else {
        icon.classList.remove("fa-times");
        icon.classList.add("fa-bars");
        changeIcon = true;
    }
});