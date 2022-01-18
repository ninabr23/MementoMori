document.getElementById("saveBtn").onclick = function () {
    const firstName = document.getElementById("f-name").value;
    const lastName = document.getElementById("l-name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const newPassword = document.getElementById("newPassword").value;
    const bday = document.getElementById("bday").value;
    const country = document.getElementById("country").value;

    const url = 'http://localhost:8080/userPage/update';
    let data = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password,
        newPassword: newPassword,
        bday: bday,
        country: country
    };

    $.ajax({
        url: url,
        data: JSON.stringify(data),
        method: "POST",
        contentType: 'application/json',
        success: function(response) {
            alert("success");
            //location.href = 'http://localhost:8080/login/'+email;
            window.location.replace('http://localhost:8080/userPage/'+email);
        },
        error: function(xhr) {
            alert("An error has occurred.");
        }
    });
};