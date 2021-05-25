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

