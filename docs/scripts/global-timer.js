
let smallGlobalTimer = document.querySelector(".timer-small__text")

function updateTime() {
    smallGlobalTimer.textContent = new Date().getHours() + ":" + new Date().getMinutes()
}

updateTime()
setInterval(updateTime,10000)