$(document).ready( function () {

  // email
  const emailInput = document.getElementById("email");
  let email = "";
  emailInput.addEventListener("change",(e) => {
    if (validateEmail(e.target.value)){
      email = e.target.value;
    }
    else {
      alert("Error... Email Invalid");
    }
  })
  const validateEmail = (email) => {
    return String(email)
      .toLowerCase()
      .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      );
  };


  // password
  const passwordInput = document.getElementById("password");
  let password = "";
  passwordInput.addEventListener("change",(e) => {
    password = e.target.value;
  })


  const form = document.getElementById("form");
  form.addEventListener("submit", (e) => {
    e.preventDefault();
    if (validateEmail(email) && password!==""){

      let item = {
        email,
        password
      }
      fetch("http://185.217.131.182:8899/api/v1/auth/sign-in",{
        method: "POST",
        body: JSON.stringify(item),
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(res => res.json())
        .then(res => {
          window.localStorage.setItem("SCHOOL_RANKING_TOKEN",res.data.tokenType+res.data.accessToken);
          alert("Sign In successfully..");
          location.href = "index.html";
          if (res.data?.success){
            email = "";
            password = "";
          }
        })
        .catch(err => {
          console.log(err);
        })
      console.log(item);
    }
    else {
      alert("Empty any item...");
    }
  });

  const redirect = document.getElementById("redirect_sign_up");
  redirect.addEventListener("click", (e) => {
    e.preventDefault();
    location.href = "SignUp.html"
  });

})
