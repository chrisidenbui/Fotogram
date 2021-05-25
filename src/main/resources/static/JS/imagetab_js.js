const heart_like = document.querySelector('.heart-icon');
let heart_click = false;
heart_like.addEventListener('click', () => {
    if (!heart_click) {
        heart_like.classList.add('open');
        heart_click = true;
    } else {
        heart_like.classList.remove('open');
        heart_click = false;
    }
})
