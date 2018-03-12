function buttonHandler(id, value) {
    if (document.inputCombo.userCombo.value.length < 4) {
        document.inputCombo.userCombo.value += value;
        document.getElementById(id).disabled = true;//disable btn for unique comb
    }
}


function resetCombo() {
    document.inputCombo.reset();
    for (var i=0;i<=9;i++) {
        document.getElementById("button"+i).disabled = false;
    }

}

function vefiryAndSendCombo() {

    if (document.getElementById("userCombo").value.length !== 4) {
        alert("Некорректная комбинация");
    }
    else
        document.getElementById("inputCombo").submit();

}

