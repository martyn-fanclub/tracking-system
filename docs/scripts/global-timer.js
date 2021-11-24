let globalTime = new Date()
let smallGlobalTimer = document.querySelector(".timer-small__text")

function updateTime() {
    console.log(smallGlobalTimer)
    smallGlobalTimer.textContent = globalTime.getHours() + ":" + globalTime.getMinutes()
}

updateTime()
setInterval(updateTime,60000)