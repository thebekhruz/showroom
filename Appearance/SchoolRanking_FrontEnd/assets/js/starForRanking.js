let language = window.localStorage.getItem("SCHOOL_RANKING_LANG");

let doneSee = false;
let cookie = window.localStorage.getItem("SCHOOL_RANKING_COOKIE");
let token = window.localStorage.getItem("SCHOOL_RANKING_TOKEN");

$(document).ready( function () {


  console.log(doneSee);
  getCookie();
  if ( getCookie()){
    getAllDate(cookie,token);
  }

})

let valueHeaderss = "";


const body = {
  type: "TOP"
}


async function getCookie(){
  if (window.localStorage.getItem("SCHOOL_RANKING_TOKEN") === null) {
    if (window.localStorage.getItem("SCHOOL_RANKING_COOKIE") === null) {
      await fetch(
        "http://185.217.131.182:8899/api/v1/cookie/data", {
          method: 'GET'
        })
        .then(res => res.json())
        .then(res => {
          let dataRes = res.data;
          valueHeaderss = dataRes.value;
          window.localStorage.setItem("SCHOOL_RANKING_COOKIE", dataRes.value);
          getAllDate(dataRes.value,token);
        })
        .catch(err => {
          window.localStorage.removeItem("SCHOOL_RANKING_COOKIE");
        });
    } else {
      getAllDate(cookie,token);
    }
  }
  else {
    getAllDate(cookie,token);
  }
  return true;
}


async function getAllDate(valueHeader,tokenHeader){
  let headers = {};
  if (tokenHeader === null) {
    headers = {
      'Content-Type': 'application/json',
      'FESSONLITEOPARES': valueHeader
    }
  }
  else {
    headers = {
      'Content-Type': 'application/json',
      'Authorization': tokenHeader,
      'Access-Control-Allow-Origin': '*'
    }
  }

  await fetch(
    "http://185.217.131.182:8899/api/v1/ranking/filter", {
      method: 'POST',
      body:JSON.stringify(body),
      headers: headers
    })
    .then(res => res.json())
    .then( res => {
      let schools = res.data;
      if (res.success === false) {
        // console.log(res.errors[0].errorMsg);
        window.localStorage.removeItem("SCHOOL_RANKING_COOKIE");
       getCookie()
      }
      else {
        renderStageList(schools);
      }
    })
    .catch(err => {
      console.log(err,"error")
    });
}

async function renderStageList(schools) {
  let html = '';
  if (schools) await schools.map(school => {
    let htmlSegment = `  <div class="inner-news-item">
               <div class="ranking-banner-image-text">
                  <img  width="250" height="70" src="http://185.217.131.182:8899/api/v1/file/get/${school.file.id}" class="ranking-banner-img" alt="">
                  <div class="ranking-banner-text">
                    <button onclick="location.href = 'school.html?schoolId=${school.id}'">${school.name}</button>
                    <span><a href="https://maps.google.com/?q=${school.address.lat},${school.address.lan}"><i class="fa-solid fa-location-dot"></i> Location</a></span>
                  </div>
               </div>
               <div class="ranking-range-slider">
                  <div class="range-slider">
                     <p>Rating</p>
                     <div class="star_wrapper hotel_a">
                        <div class="${school.id}">
                           <div class="stars-outer">
                              <div class="stars-inner"></div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <button onclick="liked('${school.id}',true)" class=${!school.liked ? "heartBgRanking" : ""}><i class="fa-solid fa-heart"></i></button>
               </div>
            </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.inner_news_wrapper');
  stageList.innerHTML = html;
}


async function liked(schoolId,status){
  let headers = {};
  const bodyItem = {
    status,
    schoolId
  }
  if (window.localStorage.getItem("SCHOOL_RANKING_TOKEN")===null) {
    if (window.localStorage.getItem("SCHOOL_RANKING_COOKIE")===null) {
      cookie = window.localStorage.getItem("SCHOOL_RANKING_COOKIE");
      headers = {
        'Content-Type': 'application/json',
        'FESSONLITEOPARES': window.localStorage.getItem("SCHOOL_RANKING_COOKIE")
      }
      await fetch(
        "http://185.217.131.182:8899/api/v1/liked/click", {
          method: 'POST',
          body:JSON.stringify(bodyItem),
          headers: headers
        })
        .then(res => res.json())
        .then( res => {
          getAllDate(window.localStorage.getItem("SCHOOL_RANKING_COOKIE"),token);
        })
        .catch(err => {
          console.log(err);
        });
    }
    else {
      headers = {
        'Content-Type': 'application/json',
        'FESSONLITEOPARES': window.localStorage.getItem("SCHOOL_RANKING_COOKIE")
      }
      await fetch(
        "http://185.217.131.182:8899/api/v1/liked/click", {
          method: 'POST',
          body:JSON.stringify(bodyItem),
          headers: headers
        })
        .then(res => res.json())
        .then( res => {
          getAllDate(window.localStorage.getItem("SCHOOL_RANKING_COOKIE"),window.localStorage.getItem("SCHOOL_RANKING_TOKEN"));
        })
        .catch(err => {
          console.log(err);
        });
      }
    }

  else {
    headers = {
      'Content-Type': 'application/json',
      'Authorization': window.localStorage.getItem("SCHOOL_RANKING_TOKEN"),
      'Access-Control-Allow-Origin': '*'
    }
    await fetch(
      "http://185.217.131.182:8899/api/v1/liked/click", {
        method: 'POST',
        body:JSON.stringify(bodyItem),
        headers: headers
      })
      .then(res => res.json())
      .then( res => {
        getAllDate(window.localStorage.getItem("SCHOOL_RANKING_COOKIE"),window.localStorage.getItem("SCHOOL_RANKING_TOKEN"));
      })
      .catch(err => {
        console.log(err);
      });
  }
}

