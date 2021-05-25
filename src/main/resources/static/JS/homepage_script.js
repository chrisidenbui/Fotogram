
// Transparent navbar when scroll window down
window.addEventListener("scroll", () => {
    var header = document.querySelector(".nav-bar");
    header.classList.toggle("sticky", window.scrollY);
})

// Burger menu
const burger = document.querySelector('.menu-button');
const navmenu = document.querySelector('.nav-menu');
const sidemenu = document.querySelector('.side-nav');
let burgerclick = false;
burger.addEventListener('click', () => {
    if (!burgerclick) {
        burger.classList.add('open');
        navmenu.classList.add('display');
        sidemenu.classList.add('display');
        burgerclick = true;
    } else {
        burger.classList.remove('open');
        navmenu.classList.remove('display');
        sidemenu.classList.remove('display');
        burgerclick = false;
    }
})


