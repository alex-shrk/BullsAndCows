function buttonHandler(id, value) {
    if (document.inputCombo.userCombo.value.length < 4) {
        document.inputCombo.userCombo.value += value;
        document.getElementById(id).disabled = true;//disable btn for unique comb
    }
}


function resetCombo() {
    document.inputCombo.reset();
    document.getElementById("button0").prop("disabled",null);

}

