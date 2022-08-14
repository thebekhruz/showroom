$(document).ready( function () {
  questionsFetch();

  /***==========================   check token   ===================================***/
  const addQuestion = document.getElementById("add__question");
  addQuestion.addEventListener("click",() => {
    let token = window.localStorage.getItem("SCHOOL_RANKING_TOKEN");
    if (token){
      formBuilder();

      /***==========================   create questions   ===================================***/
      const myForm = document.getElementById("addForm");
      const addFormInput = document.getElementById("addForm_title");
      const fileInput = document.getElementById("file");
      fileInput.addEventListener("change",(e) => {
        e.preventDefault();

        const fileData = new FormData();
        fileData.append('file',e.target.files[0]);

        fetch(
          "http://185.217.131.182:8899/api/v1/file/upload", {
            method: 'POST',
            body:fileData,
            // headers: headers
          })
          .then(res => res.json())
          .then( res => {
            let html = `<img src="http://185.217.131.182:8899/api/v1/file/get/${res.data[0].id}" width="10px" height="10px" class="community-inner-img" alt="">`;
            let stageList = document.querySelector('.fileImg');
            stageList.innerHTML = html;
          })
          .catch(err => {
            console.log(err)
          })
      })
      async function questionAdd(){
        myForm.addEventListener('submit',(e) => {
          e.preventDefault();

          const uploadElement = document.getElementById('file');

          const fileData = new FormData();
          fileData.append('file',uploadElement.files[0]);

          fetch(
            "http://185.217.131.182:8899/api/v1/file/upload", {
              method: 'POST',
              body:fileData,
              // headers: headers
            })
            .then(res => res.json())
            .then( res => {
              console.log(res.data[0].id,"............")

              const itemsSection = {
                title: addFormInput.value,
                photoId: res.data[0].id,
                body: "body"
              }

              console.log(itemsSection,"<>?//")

              const headers={
                'Content-Type': 'application/json',
                'Authorization': token,
                'Access-Control-Allow-Origin': '*'
              }
              fetch(
                "http://185.217.131.182:8899/api/v1/community/send-question", {
                  method: 'POST',
                  body:JSON.stringify(itemsSection),
                  headers
                })
                .then(res => res.json())
                .then( res => {
                  questionsFetch();
                })
                .catch(err=>{
                  console.log(err,"  2222222222")
                });

            })
            .catch(err => {
              console.log(err," 1111111111111")
            });

        })
      }
      questionAdd();
      /***==========================   create questions   ===================================***/

    }
    else {
      location.href = "SignIn.html";
    }
  })
  async function formBuilder(){
    let html = `<form action="" id="addForm" class="form">
            <div class="wrapper_form">
              <input id="file" type="file" multiple>
              <div class="fileImg" style="margin-top: 10px!important;"></div><br><br>
            </div>
            <div class="wrapper_form">
              <input id="addForm_title" type="text" placeholder="Enter question...">
              <button type="submit">Send</button>
            </div>
         </form>`;
    let stageList = document.querySelector('.question__body');
    stageList.innerHTML = html;
  }
  /***==========================   check token   ===================================***/

})


/***==========================   get questions   ===================================***/
async function questionsFetch(){
  fetch(
    "http://185.217.131.182:8899/api/v1/community/get-all", {
      method: 'GET',
    })
    .then(res => res.json())
    .then( res => {
      questionBuilder(res.data);
    });
}
async function questionBuilder(items){
  let html = '';
  items.map((item,index) => {
    let htmlSegment = `<div class="inner-news-item">
               <img src="${item.photo !== null ? 'http://185.217.131.182:8899/api/v1/file/get/'+ item.photo.id : index%2===0 ? 'assets/img/community-boy.png':'assets/img/community-girl.png'}" class="community-inner-img" alt="">
               <h4>${item.title}</h4>
            </div>`;
    html += htmlSegment;
  })

  let stageList = document.querySelector('.inner-news-listing');
  stageList.innerHTML = html;
}
/***==========================   get questions   ===================================***/

