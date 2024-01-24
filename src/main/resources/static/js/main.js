function submitForm() {
    // Получение значений полей формы
    const field1Value = document.getElementById('field1').value;
    const field2Value = document.getElementById('field2').value;
    const field3Value = document.getElementById('field3').value;

    // Создание объекта с данными для POST-запроса
    const postData = {
        name: field1Value,
        inst: field2Value,
        about: field3Value
    };

    // Отправка POST-запроса
    fetch(window.location.href+'saveAboutForm', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(postData)
    });
    hideElement();
    showElement();
}

function hideElement() {
    var myForm = document.getElementById('myForm');
    var hello = document.getElementById('hello');
    if (myForm) {
      myForm.style.display = 'none';
    }
    if (hello) {
      hello.style.display = 'none';
    }
}
function showElement() {
    var bye = document.getElementById('bye');
    if (bye) {
      bye.style.display = 'block';
    }
}