$(document).ready( function () {

  const redirect = document.getElementById("redirect_sign_in");
  redirect.addEventListener("click", (e) => {
    e.preventDefault();

    location.href = "SignIn.html"
  });

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

  // name
  const nameInput = document.getElementById("name");
  let name = "";
  nameInput.addEventListener("change",(e) => {
    name = e.target.value;
  });

  // password
  const passwordInput = document.getElementById("password");
  let password = "";
  passwordInput.addEventListener("change",(e) => {
    password = e.target.value;
  })

  // prePassword
  const prePasswordInput = document.getElementById("prePassword");
  let prePassword = "";
  prePasswordInput.addEventListener("change",(e) => {
    prePassword = e.target.value;
  })


  const form = document.getElementById("form");
  form.addEventListener("submit", (e) => {
    e.preventDefault();
    if (name!=="" && validateEmail(email) && password!=="" && prePassword!==""){
      if (password === prePassword) {
        let item = {
          name,
          email,
          password,
          prePassword
        }
        fetch("http://185.217.131.182:8899/api/v1/auth/sign-up",{
          method: "POST",
          body: JSON.stringify(item),
          headers: {
            'Content-Type': 'application/json'
          }
        })
          .then(res => res.json())
          .then(res => {
            window.localStorage.setItem("SCHOOL_RANKING_TOKEN",res.data.tokenType+res.data.accessToken);
            alert("Sign Up successfully..");
            location.href = "index.html";
            if (res.data?.success){
              name = "";
              email = "";
              password = "";
              prePassword = "";
            }

          })
          .catch(err => {
            console.log(err);
          })
        console.log(item);
      }
      else {
        alert("Password not equal pre password...");
      }
    }
    else {
      alert("Empty any item...");
    }
  });



})




async function getItems(){



}

