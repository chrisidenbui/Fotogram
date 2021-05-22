var img = document.getElementById('main_image');
var album = ['sky-5375005.jpg', 'kaysar.jpg', 'shawn.jpg', 'mario.jpg'];
var i = 0;
var active_dot = 1;

function prevImg() {
    document.getElementById('dot'+active_dot).classList.remove('active')
    if (i <= 0) {
        i = album.length;
    }
    i--;
    setDot(i);
    var s = '../Images/' + album[i];
    img.src = s;
}

function nextImg() {
    document.getElementById('dot'+active_dot).classList.remove('active')
    if (i >= album.length - 1) {
        i = -1;
    }
    i++;
    setDot(i);
    var s = '../Images/' + album[i];
    img.src = s;
}

function setDot(i){
    active_dot = i + 1;
    var dot_id = 'dot' + active_dot;
    var new_active_dot = document.getElementById(dot_id);
    new_active_dot.classList.add('active');
}
