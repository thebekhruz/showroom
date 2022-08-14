
let language = window.localStorage.getItem("SCHOOL_RANKING_LANG");


$(document).ready( function () {


  /***======================= SEARCH ==========================***/
  const search = document.getElementById("search_input");
  search.addEventListener("change",e =>{
    console.log(e.target.value);
    fetch(
      "http://185.217.131.182:8899/api/v1/main-page/search?name="+e.target.value, {
        method: 'GET',
      })
      .then(res => res.json())
      .then( res => {
        searchItemBuilder(res.data);
      });
  })
  async function searchItemBuilder(items){
    let html = '';
    items.map(item => {
      let htmlSegment = `<li onclick="location.href = 'school.html?schoolId=${item.id}'" class="search_input_item">${item.name}</li>`;
      html += htmlSegment;
    })

    let stageList = document.querySelector('.search_input_wrapper');
    stageList.innerHTML = html;
  }
  /***======================= SEARCH ==========================***/



  popularDiscussions();

})


/***======================= POPULAR DISCUSSIONS ==========================***/

async function popularDiscussions(){
  fetch(
    "http://185.217.131.182:8899/api/v1/main-page/populars", {
      method: 'GET',
    })
    .then(res => res.json())
    .then( res => {
      popularDiscussionsItemBuilder(res.data);
    });
}
async function popularDiscussionsItemBuilder(items){
  let html = '';
  items.map(item => {
    let htmlSegment = ` <div class="news-card-listing-item">
                  <div class="news-card-listing-image"><img src="${item.photoUrl ? 'http://185.217.131.182:8899/api/v1/file/get/'+item.photoUrl.id : 'assets/img/header-logo.svg'}" width="210px" alt=""></div>
                  <div class="news-card-listing-item-content">
                     <a href="#" class="news-card-title">${item.title}</a>
                     <p>${item.body}<span>by ${item.username} - ${Date(item.writtenTime)}</span></p>
                     <div class="news-card-listing-item-btn">
                        <a href="#"><img src="assets/img/news-card-icon-1.svg" alt=""> ${item.views}</a>
                        <a href="#"><img src="assets/img/news-card-icon-2.svg" alt=""> ${item.shares}</a>
                     </div>
                  </div>
               </div>`;
    html += htmlSegment;
  })

  let stageList = document.querySelector('.news-card-listing-wrapper');
  stageList.innerHTML = html;
}

/***======================= POPULAR DISCUSSIONS ==========================***/









