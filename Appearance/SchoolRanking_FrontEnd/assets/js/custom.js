

function changeLanguageFields(lang){
  //navbar
  const rank = document.querySelector(".core_menu_rank");
  const aboutUs = document.querySelector(".core_menu_about_us");
  const community = document.querySelector(".core_menu_community");
  const myAccount = document.querySelector(".core_menu_my_account");

  // about
  const aboutTitle = document.querySelector(".about__title");
  const aboutDescription1 = document.querySelector(".about__description_1");
  const aboutDescription2 = document.querySelector(".about__description_2");
  const aboutDescription3 = document.querySelector(".about__description_3");

  const aboutDescription4 = document.querySelector(".about__description_4");
  const aboutDescription5 = document.querySelector(".about__description_5");
  const aboutDescription6 = document.querySelector(".about__description_6");
  const become__title = document.querySelector(".become__title");
  const pending__title = document.querySelector(".lang__pending__title");
  const pending__description = document.querySelector(".lang__pending__description");


  //footer
  const rankFooter = document.querySelector(".core_menu_rank_footer");
  const aboutUsFooter = document.querySelector(".core_menu_about_us_footer");
  const communityFooter = document.querySelector(".core_menu_community_footer");
  const myAccountFooter = document.querySelector(".core_menu_my_account_footer");
  const subscribeNewsletter = document.querySelector(".subscribe__newsletter");
  const footerCopyright = document.querySelector(".footer__copyright");
  const footerHowWeRank = document.querySelector(".footer_how_we_rank");
  const footerBecomeMember = document.querySelector(".footer_become_member");
  const footerContactUs = document.querySelector(".footer_contact_us");

  // index.html
  const listTo = document.querySelector(".lang__list__to");
  const roadCollege = document.querySelector(".lang__road__college");
  const whichProgram = document.querySelector(".lang__which__program");
  const communityParents = document.querySelector(".lang__community__parents");
  const videos = document.querySelector(".lang__videos");
  const browserAllSchool = document.querySelector(".lang__browser__all__schools");
  const popularDiscussion = document.querySelector(".lang__popular__discussions");

  //community.html
  const addQuestions = document.querySelector(".lang__add_questions");



  if (lang==="ru") {
    rank !== null ? rank.innerHTML = "Оценка" : "";
    aboutUs !==null ? aboutUs.innerHTML = "О Нас" : "";
    community !==null ? community.innerHTML = "Общество":"";
    myAccount !==null ? myAccount.innerHTML = "Мой Аккаунт":"";

    rankFooter !==null ? rankFooter.innerHTML = "Оценка":"";
    aboutUsFooter !==null ? aboutUsFooter.innerHTML = "О Нас":"";
    communityFooter !==null ? communityFooter.innerHTML = "Общество":"";
    myAccountFooter !==null ? myAccountFooter.innerHTML = "Мой Аккаунт":"";

    aboutDescription1 !==null ? aboutDescription1.innerHTML = "Привет! После того, как мы обнаружили, что более 7000 родителей ищут “Лучшие школы Ташкента” в Яндексе и Google, мы решили создать этот сайт. Наша миссия состоит в том, чтобы родителям было очень легко выбрать правильную школу для своих детей. А также создать сообщество, где каждый родитель может просто задать вопрос или написать отзыв о школе.":"";
    aboutDescription2 !==null ? aboutDescription2.innerHTML = "Мы оцениваем школы, собирая данные об успеваемости их учащихся, а также о других возможностях, предоставляемых такими школами. Таким образом, вы не будете тратить время на поиски школы, которая даст лучшее образование. Мы надеемся, что наш веб-сайт предоставит вам ценные знания, которые помогут вам принять правильное решение, и мы оправдаем ваши ожидания. Искренне ваш, SchoolRanking.uz .":"";
    aboutDescription3 !==null ? aboutDescription3.innerHTML = "Чтобы связаться с нами, пожалуйста, напишите нашему директору службы поддержки по электронной почте: thebekhruz@gmail.com":"";


    subscribeNewsletter !==null ? subscribeNewsletter.innerHTML = "Подписывайтесь на нашу новостную рассылку":"";
    footerCopyright !==null ? footerCopyright.innerHTML = `Copyright © ${new Date().getFullYear()}. Все права защищены.`:"";
    footerContactUs !==null ? footerContactUs.innerHTML = "Свяжитесь с нами":"";
    footerBecomeMember !==null ? footerBecomeMember.innerHTML = "Стать участником":"";
    footerHowWeRank !==null ? footerHowWeRank.innerHTML = "Как мы оцениваем":"";
    become__title !==null ? become__title.innerHTML = "Стать участником!":"";
    pending__title !==null ? pending__title.innerHTML = "В ожидании.":"";
    pending__description !==null ? pending__description.innerHTML = "Здравствуйте, мы ценим, что вы заинтересовались этой страницей. Тем не менее, эта страница развивается. Будьте уверены, что мы прилагаем все усилия, чтобы сделать его доступным для вас как можно скорее.":"";

    // index.html
    listTo !==null ? listTo.innerHTML = "ССЫЛКИ НА:":"";
    roadCollege !==null ? roadCollege.innerHTML = "ДОРОГА В КОЛЛЕДЖ":"";
    whichProgram !==null ? whichProgram.innerHTML = "КАКУЮ ПРОГРАММУ ВЫБРАТЬ":"";
    communityParents !==null ? communityParents.innerHTML = "СООБЩЕСТВО РОДИТЕЛЕЙ":"";
    videos !==null ? videos.innerHTML = "ВИДЕО":"";
    browserAllSchool !==null ? browserAllSchool.innerHTML = `ПОСМОТРЕТЬ ВСЕ ШКОЛЫ<img src="assets/img/btn-arrow-black.svg" alt="">`:"";
    popularDiscussion !==null ? popularDiscussion.innerHTML = "ПОПУЛЯРНЫЕ ОБСУЖДЕНИЯ":"";

    //community.html
    addQuestions !==null ? addQuestions.innerHTML = "Добавить Вопрос":"";



    if (aboutDescription4 && aboutDescription5 && aboutDescription6) {
      aboutDescription4.innerHTML = "Если вы заинтересованы в том, чтобы стать членом нашей замечательной группы школ, свяжитесь с нами по электронной почте: thebekhruz@gmail.com.";
      aboutDescription5.innerHTML = "Стать участником абсолютно бесплатно.";
      aboutDescription6.innerHTML = "Пожалуйста, убедитесь, что в теме письма указано «Новый участник». И, пожалуйста, укажите название школы.";
    }
  }
  if (lang==="en") {
    rank !== null ? rank.innerHTML = "Ranks" : "";
    aboutUs !== null ? aboutUs.innerHTML = "About Us" : "";
    community !== null ? community.innerHTML = "Community" : "";
    myAccount !== null ? myAccount.innerHTML = "My Account" :"";

    rankFooter !== null ? rankFooter.innerHTML = "Ranks" : "";
    aboutUsFooter !== null ? aboutUsFooter.innerHTML = "About Us" : "";
    communityFooter !== null ? communityFooter.innerHTML = "Community" : "";
    myAccountFooter !== null ? myAccountFooter.innerHTML = "My Account" : "";

    aboutTitle !== null ? aboutTitle.innerHTML = "About Us" : "";
    aboutDescription1 !== null ? aboutDescription1.innerHTML = "Hello there! After we have discovered, that more than 7,000 parents are looking for “Best Schools in Tashkent” on Yandex and Google, we have decided to create this website. Our mission is to make it super easy for parents to choose the right school for their children. As well as to create a community where every parent can simply ask a question or write a review of the school." : "";
    aboutDescription2 !== null ? aboutDescription2.innerHTML = "We rank schools by collecting data about the academic performances of their students, as well as other facilities that such schools provide. Therefore,  you won’t waste time trying to find the school that will give the best education. We hope that our website will provide you with valuable knowledge that will assist you in making the right decision, and we will meet your expectations. Sincerely yours, SchoolRanking.uz.":"";
    aboutDescription3 !== null ? aboutDescription3.innerHTML = "To contact us please email, our support director: thebekhruz@gmail.com ":"";


    subscribeNewsletter !== null ? subscribeNewsletter.innerHTML = "Subscribe to Our Newsletter" : "";
    footerCopyright !== null ? footerCopyright.innerHTML = `Copyright © ${new Date().getFullYear()}. All rights reserved.`:"";
    footerContactUs !== null ? footerContactUs.innerHTML = "Contact Us":"";
    footerBecomeMember !== null ? footerBecomeMember.innerHTML = "Become a member":"";
    footerHowWeRank !== null ? footerHowWeRank.innerHTML = "How we rank" : "";
    become__title !==null ? become__title.innerHTML = "Become a member!":"";
    pending__title !==null ? pending__title.innerHTML = "Pending.":"";
    pending__description !==null ? pending__description.innerHTML = "Hello there, we appreciate that you are interested in this page. However, this page is developing. Be assured that we are working hard to make it available for you as soon as possible.":"";

    //index.html
    listTo !==null ? listTo.innerHTML = "LINKS TO :":"";
    roadCollege !==null ? roadCollege.innerHTML = "ROAD TO COLLEGE":"";
    whichProgram !==null ? whichProgram.innerHTML = "WHICH PROGRAM TO CHOOSE":"";
    communityParents !==null ? communityParents.innerHTML = "COMMUNITY OF PARENTS":"";
    videos !==null ? videos.innerHTML = "VIDEOS":"";
    browserAllSchool !==null ? browserAllSchool.innerHTML = `BROWSE ALL SCHOOLS<img src="assets/img/btn-arrow-black.svg" alt="">`:"";
    popularDiscussion !==null ? popularDiscussion.innerHTML = "POPULAR DISCUSSIONS":"";

    //community.html
    addQuestions !==null ? addQuestions.innerHTML = "Add Question":"";




    if (aboutDescription4 && aboutDescription5 && aboutDescription6) {
      aboutDescription4.innerHTML = "If you are interested in becoming a member of our wonderful group of schools, please contact us using this email: thebekhruz@gmail.com.";
      aboutDescription5.innerHTML = "It Is absolutely free to become a member.";
      aboutDescription6.innerHTML = "Please make sure that the subject of the letter is New Member. And please include the name of the school.";
    }
  }
  console.log("456")
}


$(document).ready(function(){

  let language = window.localStorage.getItem("SCHOOL_RANKING_LANG");
  if (language === "en"){
    const en = document.getElementById("lang_item_en");
    en.setAttribute("selected",true);
    changeLanguageFields(language);
  }
  if (language === "ru"){
    const ru = document.getElementById("lang_item_ru");
    ru.setAttribute("selected",true);
    changeLanguageFields(language)
  }
  if (language === null) changeLanguageFields("en")

  //the trigger on hover when cursor directed to this class
    $(".core-menu li").click(
    function(){
      //i used the parent ul to show submenu
        $(this).children('ul').toggleClass(".fast");
    }, 
      //when the cursor away 
    function () {
      var isFast = $(this).children('ul').is('.fast');
       $('.core-menu li ul.fast').removeClass('fast');
       $(this).children('ul').toggleClass('fast', !isFast);
        
    });
  //this feature only show on 600px device width
    $(".hamburger-menu").click(function(){
      $(".burger-1, .burger-2, .burger-3").toggleClass("open");
        $(".core-menu").toggleClass("fast");
      $(".main-menu").toggleClass("menu-open");  
    });

  const emailInput = document.getElementById("subscribe_us");
  emailInput.addEventListener("change",(e) => {
    if (validateEmail(e.target.value)){
      subscribeUs(e.target.value);
      emailInput.value="";
    }
    else {
      alert("Error... Email Invalid");
    }
  })

  const selectLang = document.getElementById("language__select");
  selectLang.addEventListener("change", (e) => {
    console.log(e.target.value,"lang")
    window.localStorage.setItem("SCHOOL_RANKING_LANG",e.target.value);
    language = window.localStorage.getItem("SCHOOL_RANKING_LANG");

    changeLanguageFields(language);
  });

});



const validateEmail = (email) => {
  return String(email)
    .toLowerCase()
    .match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );
};

async function subscribeUs(email){
  let headers = {
    'Content-Type': 'application/json',
  }
  const bodyItem = { email }
  console.log(bodyItem," email");
  await fetch(
    "http://185.217.131.182:8899/api/v1/main-page/subs-news?email="+email, {
      method: 'POST',
      body:JSON.stringify(bodyItem),
      headers: headers
    })
    .then(res => res.json())
    .then( res => {
      if (res.success) {
        alert(res.message)
      }
      else {
        alert("Email exist. Please enter other email!")
      }
    })
    .catch(err=>alert(err));
}




 $('.slider-nav').slick({
   slidesToShow: 1,
   slidesToScroll: 1,
   arrows: true,
   fade: true,
   dots: false,
   asNavFor: '.slider-for',
     responsive: [
    {
      // If Screen Size More than 768px
      breakpoint: 1200,
      settings: {
        dots: true,
        arrows: false,
      }
    }
  ]
 });
 $('.slider-for').slick({
   slidesToShow: 3,
   slidesToScroll: 1,
   asNavFor: '.slider-nav',
   dots: false,
   focusOnSelect: true
 });



  $('.testimonial-sec-slider').slick({
    infinite: true,    
    slidesToShow: 3,
    slidesToScroll: 1,
    arrows: false,
    dots: true,
    autoplay: true,
    swipe: true,
         responsive: [
    {
      // If Screen Size More than 768px
      breakpoint: 1200,
      settings: {
        dots: true,
        arrows: false,
        centerMode: true,
        variableWidth: true,
      }
    }
  ]
  });



  $('.testimonial-sec-slider-city-page').slick({
    infinite: true,    
    slidesToShow: 2,
    slidesToScroll: 1,
    arrows: false,
    dots: true,
    autoplay: false,
    swipe: true,
         responsive: [
    {
      breakpoint: 1200,
      settings: {
        dots: true,
        arrows: false,
        centerMode: true,
        variableWidth: true,
      }
    }
  ]
  });


  $('.partners-slider').slick({
    infinite: true,    
    slidesToShow: 2,
    slidesToScroll: 1,
    arrows: false,
    dots: true,
    autoplay: false,
    swipe: true,
         responsive: [
    {
      // If Screen Size More than 768px
      breakpoint: 1200,
      settings: {
        dots: true,
        arrows: false,
        centerMode: true,
        variableWidth: true,
      }
    }
  ]
  });


  $('.masterhead-slider-banner-slider').slick({
    infinite: true,    
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: true,
    dots: true,
    autoplay: false,
    swipe: true,
    responsive: [
      {
        breakpoint: 1199,
        settings: {
          arrows: false,
        }
      }
    ]
  });

// sticky section in scrolling

$(function() {
  var top = $('#sidebar').offset().top - parseFloat($('#sidebar').css('marginTop').replace(/auto/, 0));
  var footTop = $('#footer').offset().top - parseFloat($('#footer').css('marginTop').replace(/auto/, 0));

  var maxY = footTop - $('#sidebar').outerHeight();

  $(window).scroll(function(evt) {
    var y = $(this).scrollTop();
    if (y > top) {
      if (y < maxY) {
        $('#sidebar').addClass('fixed').removeAttr('style');
      } else {
        $('#sidebar').removeClass('fixed').css({
          // position: 'absolute',
          // top: (maxY - top) + 'px'
        });
      }
    } else {
      $('#sidebar').removeClass('fixed');
    }
  });
});








$(".button").click(function(){
    $("body") .addClass('modal-open');
    $("#step-form").css("display","block");
    
});


$(".cancel").click(function(){
    $("body") .removeClass('modal-open');
     $("#step-form").fadeOut();
});



$(document).ready(function(){

var current_fs, next_fs, previous_fs; //fieldsets
var opacity;
var current = 1;
var steps = $("fieldset").length;

setProgressBar(current);

$(".next").click(function(){

current_fs = $(this).parent();
next_fs = $(this).parent().next();

//Add Class Active
$("#progressbar li").eq($("fieldset").index(current_fs)).addClass("active");
//$("#account").addClass("active");

//show the next fieldset
next_fs.show();
//hide the current fieldset with style
current_fs.animate({opacity: 0}, {
step: function(now) {
// for making fielset appear animation
opacity = 1 - now;

current_fs.css({
'display': 'none',
});
next_fs.css({'opacity': opacity});
},
duration: 500
});
setProgressBar(++current);
});

$(".previous").click(function(){

current_fs = $(this).parent();
previous_fs = $(this).parent().prev();

//Remove class active
$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

//show the previous fieldset
previous_fs.show();

//hide the current fieldset with style
current_fs.animate({opacity: 0}, {
step: function(now) {
// for making fielset appear animation
opacity = 1 - now;

current_fs.css({
'display': 'none',
});
previous_fs.css({'opacity': opacity});
},
duration: 500
});
setProgressBar(--current);
});

function setProgressBar(curStep){
var percent = parseFloat(100 / steps) * curStep;
percent = percent.toFixed();
$(".progress-bar")
.css("width",percent+"%")
}

$(".submit").click(function(){
return false;
})

});


var x, i, j, l, ll, selElmnt, a, b, c;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
l = x.length;
for (i = 0; i < l; i++) {
  selElmnt = x[i].getElementsByTagName("select")[0];
  ll = selElmnt.length;
  /*for each element, create a new DIV that will act as the selected item:*/
  a = document.createElement("DIV");
  a.setAttribute("class", "select-selected");
  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
  x[i].appendChild(a);
  /*for each element, create a new DIV that will contain the option list:*/
  b = document.createElement("DIV");
  b.setAttribute("class", "select-items select-hide");
  for (j = 1; j < ll; j++) {
    /*for each option in the original select element,
    create a new DIV that will act as an option item:*/
    c = document.createElement("DIV");
    c.innerHTML = selElmnt.options[j].innerHTML;
    c.addEventListener("click", function(e) {
        /*when an item is clicked, update the original select box,
        and the selected item:*/
        var y, i, k, s, h, sl, yl;
        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
        sl = s.length;
        h = this.parentNode.previousSibling;
        for (i = 0; i < sl; i++) {
          if (s.options[i].innerHTML == this.innerHTML) {
            s.selectedIndex = i;
            h.innerHTML = this.innerHTML;
            y = this.parentNode.getElementsByClassName("same-as-selected");
            yl = y.length;
            for (k = 0; k < yl; k++) {
              y[k].removeAttribute("class");
            }
            this.setAttribute("class", "same-as-selected");
            break;
          }
        }
        h.click();
    });
    b.appendChild(c);
  }
  x[i].appendChild(b);
  a.addEventListener("click", function(e) {
      /*when the select box is clicked, close any other select boxes,
      and open/close the current select box:*/
      e.stopPropagation();
      closeAllSelect(this);
      this.nextSibling.classList.toggle("select-hide");
      this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
  /*a function that will close all select boxes in the document,
  except the current select box:*/
  var x, y, i, xl, yl, arrNo = [];
  x = document.getElementsByClassName("select-items");
  y = document.getElementsByClassName("select-selected");
  xl = x.length;
  yl = y.length;
  for (i = 0; i < yl; i++) {
    if (elmnt == y[i]) {
      arrNo.push(i)
    } else {
      y[i].classList.remove("select-arrow-active");
    }
  }
  for (i = 0; i < xl; i++) {
    if (arrNo.indexOf(i)) {
      x[i].classList.add("select-hide");
    }
  }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);



const settings={
fill: '#29ABE2',
background: '#d7dcdf'
}

const sliders = document.querySelectorAll('.range-slider');

Array.prototype.forEach.call(sliders,(slider)=>{
slider.querySelector('input').addEventListener('input', (event)=>{
slider.querySelector('span').innerHTML = event.target.value;
applyFill(event.target);
});
applyFill(slider.querySelector('input'));
});

function applyFill(slider) {
const percentage = 100*(slider.value-slider.min)/(slider.max-slider.min);
const bg = `linear-gradient(90deg, ${settings.fill} ${percentage}%, ${settings.background} ${percentage+0.1}%)`;
slider.style.background = bg;
}





