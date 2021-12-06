let closePopupBTN = document.querySelectorAll(`.popup__close-button`)
let openPopupBTN = document.querySelectorAll(`.button_open-popup`)

let popups = document.querySelectorAll(".popup")
let main = document.querySelector("main")


function openPopup(el) {
    
    let i = 0
    while (popups[i].dataset.machineId !== el){
        i++
    }
    
    popups[i].style.visibility = "visible"
}

function closePopup(el) {
    let i = 0
    while (popups[i].dataset.machineId !== el){
        i++
    }
    
    popups[i].style.visibility = "hidden"
}

function getMachineId(el) {
    let parent = el
    while (((parent.dataset == null) || !parent.dataset.machineId) && (parent !== main)){
        parent = parent.parentElement
    }
    return parent.dataset.machineId
}

getMachineId(document.querySelector(".user-panel__machine-name"))

for (let i = 0; i < popups.length; i++) {
    openPopupBTN[i].addEventListener('click', () => openPopup(getMachineId(openPopupBTN[i])))
    closePopupBTN[i].addEventListener('click', () => closePopup(getMachineId(closePopupBTN[i])))
}
