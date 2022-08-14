const ratings = {
  hotel_a : 3.3
};

// total number of stars
const starTotal = 5;

for(const rating in ratings) {
  const starPercentage = (ratings[rating] / starTotal) * 100;
  document.querySelector(`.${rating} .stars-inner`).style.width = `${(Math.round(starPercentage / 10) * 10)}%`;
}



$(document).ready( function () {

  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  const schoolId = urlParams.get('schoolId')

  getCookie(schoolId);

})


async function getCookie(schoolId){
  await fetch(
    "http://185.217.131.182:8899/api/v1/school-page/get-school/"+schoolId, {
      method: 'GET'
    })
    .then(res => res.json())
    .then( res => {
      let dataRes = res.data;
      console.log(dataRes);

      renderStageList(dataRes);
      renderSchoolNumbers(dataRes);
      renderRankAdmin1(dataRes);

    })
    .catch(err=>{
      console.log(err,"res")
    });
}

async function renderStageList(data) {
  let html = `<div class="inner-about-wrapper">
            <div class="inner-about-wrapper-left">
               <div class="inner-about-image"><img style="border-radius: 50%" src="http://185.217.131.182:8899/api/v1/file/get/${data.logo.id}" width="300px" height="300px" alt=""></div>
               <div class="inner-about-wrapper-left-info">
               <a href="https://maps.google.com/?q=${data.address.lat},${data.address.lan}">
                   <img src="assets/img/location-pin.svg" alt=""> Address
               </a>
               </div>
            </div>

            <div class="inner-about-content">
               <h2>${data.name}</h2>
               <p style="font-size: 24px">${data.description}</p>
            </div>
         </div>

         <div class="inner-about-wrapper award-wrapper">
            
               <div class="inner-about-image">
                  <h2 class="lang__award" style="width: 100%;display:flex;align-items: center">Award</h2>
           
                  <div class="award-image-wrapper">
                     <div class="award-wrapper-image-item">
                        <img src="assets/img/award-wrapper-image-1.png" alt="">
                        <h3>Gold for social impact <br>(teaching award)</h3>
                     </div>
                     <div class="award-wrapper-image-item">
                        <img src="assets/img/award-wrapper-image-2.png" alt="">
                        <h3>Silver for<br> environmental impact<br>(sport award)</h3>
                     </div>
                  </div>  
            </div>
            <div class="inner-about-wrapper-left">
               <div class="inner-about-wrapper-left-info">
                  <a href="${data.website}">Go to web site of school</a>
               </div>
               <div class="inner-about-content">
                  <h2>Contact Information</h2>
                  <ul class="award-info-listing">
                     <li>
                        <div class="award-info-listing-item">
                           <h3>Address</h3>
                           <a href="https://maps.google.com/?q=${data.address.lat},${data.address.lan}"><span><img src="assets/img/award-info-listing-icon-1.svg" alt=""></span>Location</a>
                        </div>
                     </li>
                     <li>
                        <div class="award-info-listing-item">
                           <h3>Phone No.</h3>
                           <a href="tel:${data.phoneNumber}"><span><img src="assets/img/award-info-listing-icon-2.svg" alt=""></span>${data.phoneNumber}</a>
                        </div>
                     </li>
                     <li>
                        <div class="award-info-listing-item">
                           <h3>Email</h3>
                           <a href="mailto:${data.email}"><span><img src="assets/img/award-info-listing-icon-3.svg" alt=""></span>${data.email}</a>
                        </div>
                     </li>
                  </ul>
               </div>
            </div>
         </div>`;

  let stageList = document.querySelector('.inner-about');
  stageList.innerHTML = html;
}

async function renderSchoolNumbers(data) {
  if (data.stages.length!==0) {
    let html = '';
    data.stages.map(stage => {
      let htmlSegment = `<div class="school-numbers-item">
                  <h3><span>${stage.count}</span>${stage.name}</h3>
               </div>
             `;
      html += htmlSegment;
    });
    let stageList = document.querySelector('.school-numbers-wrapper');
    stageList.innerHTML = html;
  }
  else {
    let html = `<div class="school-numbers-item">
                  <h3><span>Pending...</span>Amount of students in<br> elementary schools</h3>
               </div>
               <div class="school-numbers-item">
                  <h3><span>Pending...</span>Secondary   school</h3>
               </div>
               <div class="school-numbers-item">
                  <h3><span>Pending...</span>High school</h3>
               </div>`;
    let stageList = document.querySelector('.school-numbers-wrapper');
    stageList.innerHTML = html;
  }
}

async function renderRankAdmin1(data) {
  if (data.rankAdmin!==0) {
    let html = `<div class="comment-block-rating">${data.rankAdmin}<span>10</span></div>`;
    let stageList = document.querySelector('.rankAdmin1');
    stageList.innerHTML = html;
  }
  else {
    let html = `<div class="comment-block-rating" style="margin-bottom: 10px">?</div>`;
    let stageList1 = document.querySelector('.rankAdmin1');
    let stageList2 = document.querySelector('.rankAdmin2');
    stageList1.innerHTML = html;
    stageList2.innerHTML = html;
  }
}
