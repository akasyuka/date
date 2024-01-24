const FirstComponent = () => {
const styles = {
  color: 'red',
  fontSize: '16px',
};

return React.createElement('div', { style: styles }, 'Привет, мир!');
};

const SecondComponent = () => {
const styles = {
  color: 'blue',
  fontSize: '20px',
};

return React.createElement('div', { style: styles }, 'Привет еще раз!');
};

ReactDOM.render(
React.createElement(FirstComponent),
document.getElementById('hello')
);

ReactDOM.render(
React.createElement(SecondComponent),
document.getElementById('hello again')
);