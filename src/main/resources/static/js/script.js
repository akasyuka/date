document.addEventListener('DOMContentLoaded', () => {
    sendGetRequest();
});

function sendGetRequest() {
    const url = window.location.href+'isAnswered';

    fetch(url)
        .then(response => response.json())
        .then(data => {
            var cat = document.getElementById('cat');
            var catBack = document.getElementById('catBack');
            var ask = document.getElementById('ask');
            var yes = document.getElementById('yes');
            var no = document.getElementById('no');

            if (data.isAnswered === false) {
                // Замена класса элемента на новый класс
                cat.className = 'visible';
                catBack.className = 'invisible';
                ask.className = 'visible';
                yes.className = 'variant-visible';
                no.className = 'variant-visible';
            } else {
                cat.className = 'invisible';
                catBack.className = 'visible';
                ask.className = 'invisible';
                yes.className = 'variant-invisible';
                no.className = 'variant-invisible';
            }

        })
        .catch(error => {
            console.error('Error during fetch:', error);
        });
}

async function clickYes() {
    const postUrl = window.location.href+'updateClickCount';
                    const postData = {
                        clickCount: 1,
                        yesOrNot: 'YES'
                    };

                    await fetch(postUrl, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(postData)
                    })
                        .then(postResponse => postResponse.json())
                        .then(postData => {
                            // Обработка данных после POST-запроса
                            console.log('POST response:', postData);
                        })

                        sendGetRequest()
}

async function clickNo() {
    const postUrl = window.location.href+'updateClickCount';
                    const postData = {
                        clickCount: 1,
                        yesOrNot: 'NO'
                    };

                    await fetch(postUrl, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(postData)
                    })
                        .then(postResponse => postResponse.json())
                        .then(postData => {
                            // Обработка данных после POST-запроса
                            console.log('POST response:', postData);
                        })

                        sendGetRequest()
}




