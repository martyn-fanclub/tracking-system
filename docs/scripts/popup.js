let closePopupBTN = document.querySelectorAll(`.popup__close-button`)
let openPopupBTN = document.querySelectorAll(`.button_open-popup`)

let popupContainer = document.querySelector(".popup-container")
let popups = document.querySelectorAll(".popup")
let main = document.querySelector("main")


function openPopup(el) {
    popupContainer.style.visibility = "visible"
    let i = 0
    while (popups[i].dataset.machineId !== el){
        i++
    }
    
    popups[i].style.visibility = "visible"
}

function closePopup(el) {
    popupContainer.style.visibility = "hidden"
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

openPopupBTN[0].addEventListener('click', () => openPopup(getMachineId(openPopupBTN[0])))
openPopupBTN[1].addEventListener('click', () => openPopup(getMachineId(openPopupBTN[1])))
closePopupBTN[0].addEventListener('click', () => closePopup(getMachineId(closePopupBTN[0])))
closePopupBTN[1].addEventListener('click', () => closePopup(getMachineId(closePopupBTN[1])))