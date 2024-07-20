var g_host = "127.0.0.1:8080";

var common_localstorage_key = "common_localstorage_key";

var base_image_url = "http://localhost:10001/htmlStable"

function currentTime() {
    var time = new Date();
    var Y = time.getFullYear();
    var M = time.getMonth();
    M = (M + 1) < 10 ? '0' + (M + 1) : (M + 1);  //这里月份加1的原因是因为月份是从0开始的，0-11月，加1让月份从1-12月区间。
    var d = time.getDate();
    d = d < 10 ? '0' + d : d;
    var h = time.getHours();
    h = h < 10 ? '0' + h : h;
    var m = time.getMinutes();
    m = m < 10 ? '0' + m : m;
    var s = time.getSeconds();
    s = m < 10 ? '0' + m : m;
    return Y + "-" + M + "-" + d + " " + h + ":" + m + ":" + s;
}

function set(key, value) {
    localStorage.setItem(key, value);
}

function get(key) {
    return localStorage.getItem(key);
}

function getImageUrl(url) {
    return base_image_url + url;
}

function dateFormat(dateTime) {
    if (dateTime.indexOf('T') != -1) {
        dateTime += ':00'
        dateTime = dateTime.replace('T', ' ')
        return dateTime;
    }
}

function showDateFormat(dateTime) {
    dateTime = dateFormat(dateTime);
    if (dateTime.indexOf(".") != -1) {
        dateTime = dateTime.split(".")[0]
    }
    return dateTime;
}


function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}


