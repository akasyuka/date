function hideButton() {

    var button = document.getElementById('ans');
        button.style.display = 'none';
    var div = document.getElementById('ask');
            div.style.display = 'none';
    var cat = document.getElementById('cat');
                cat.style.display = 'none';
    var catBack = document.getElementById('catBack');
                catBack.style.display = 'block';
                catBack.style.textAlign  =  'center';
                catBack.style.marginLeft = 'auto';
                catBack.style.marginRight = 'auto';
}
function showAnsYes() {
    var messageDiv = document.getElementById('ansYes');
    messageDiv.style.display = 'block';
    messageDiv.style.fontSize = '80px';
}

function showAnsNo() {
    var messageDiv = document.getElementById('ansNo');
    messageDiv.style.display = 'block';
    messageDiv.style.fontSize = '80px';
}
function clickYes() {
    var xhr = new XMLHttpRequest();
            xhr.open('POST', '/updateClickCount', true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({ clickCount: 1, yesOrNotEnum: 'YES'  }));
    hideButton();
    showAnsYes();
}

function clickNo() {
    var xhr = new XMLHttpRequest();
            xhr.open('POST', '/updateClickCount', true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({ clickCount: 1, yesOrNotEnum: 'NO'  }));
    hideButton();
    showAnsNo();
}

document.addEventListener("DOMContentLoaded", function () {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/isAnswered', true);
    xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                var response = JSON.parse(xhr.responseText);
                if (response.isAnswered) {
                    hideButton();
                }
            }
    };
    xhr.send();
});