
// Transparent navbar when scroll window down
window.addEventListener("scroll", () => {
    var header = document.querySelector(".nav-bar");
    header.classList.toggle("sticky", window.scrollY);
})

window.addEventListener("load", () => {
    //Function to open Image Pane
    const all_post = document.querySelectorAll('.col > img');
    openImageTab(all_post);

    const all_carousel = document.querySelectorAll('.carousel-item > img');
    openImageTab(all_carousel);
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

//Fetch API and put in Post class
class Post{
    constructor(img_src, download_urls, username, likes, tags, description) {
        this._img_src = img_src;
        this._download_urls = download_urls;
        this._username = username;
        this._likes = likes;
        this._tags = tags;
        this._description = description;
    }

    get img_src() {
        return this._img_src;
    }

    get download_urls() {
        return this._download_urls;
    }

    get username() {
        return this._username;
    }

    get likes() {
        return this._likes;
    }

    get tags() {
        return this._tags;
    }

    get description() {
        return this._description;
    }
}

fetch('http://localhost:8080/posts')
    .then(response => response.json())
    .then(json => {
        console.log(json);
        // for (let j = 0; j < json.length; j++) {
        //     let currResult = json[j];
        //     let newPost = new Post(currResult.urls, currResult.username, currResult.likes, tagList, currResult.description);
        //     postList.push(newPost);
        // }
    })


//General function of opening Image Tab
function openImageTab(all) {
    for (let a = 0; a < all.length; a++) {
        all[a].addEventListener('click', () =>{
             window.location = './imagetab?id=' + a;
        })
    }
}

//Function to display posts
function displayPosts() {
    const all2 = document.querySelectorAll('.box > img');
    for (let a = 0; a < all2.length; a++) {
        all2[a].src = postList[a];
    }
}
