$(document).ready( function () {
  getAllDate();

  renderStageList();
  // create();
})





async function getAllDate(){
  await fetch(
    "http://185.217.131.182:8899/api/v1/online-form/data", {
      method: 'GET'
    })
    .then(res => res.json())
    .then( res => {

      console.log(res)

      let dataRes = res.data;

      console.log(dataRes,"datares")

      renderStageList(dataRes.stageList);
      renderPercentageStudent(dataRes.markList);
      renderPercentageIELTS(dataRes.markList);
      renderPercentageSubjectAndArts(dataRes.subjectList,dataRes.markList);
      renderImpactList(dataRes.impactList);
      renderActivityList(dataRes.activityList);
      renderSportAward(dataRes.sportFacilityList);
      renderSystemList(dataRes.systemList);
    })
    .catch(err=>{
      console.log(err,"res")
    });
}

// 4-------------------------------------------------------------------------------
async function renderStageList(stages) {
  let html = '';
  await stages.map(stage => {
    let htmlSegment = `<div class="stageList_item">
                            <label for="${stage.id}" class="stageList_item_title">${stage.nameEn}:</label>
                            <input id="${stage.id}" class="stageList_item_input" type="text">
                        </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.stageList');
  stageList.innerHTML = html;
}

// 5-------------------------------------------------------------------------------
async function renderPercentageStudent(admissions) {
  console.log(admissions,"admissions")
  let html = '';
  await admissions.map(admission => {
    if (admission.type==="ADMISSION") {
      let htmlSegment = ` <div class="stageList_item">
                            <input id="${admission.first}_${admission.second}" name="student" class="stageList_item_input" type="radio">
                            <label for="${admission.first}_${admission.second}" class="stageList_item_title">
                                ${admission.firstStatus === "GREATER_OR_EQUAL" ?admission.first + " ≤  " : " < "}
                                percentage
                                ${admission.secondStatus === "LESS" ? " < " : "  ≤ "}
                                ${admission.second}
                            </label>
                        </div>`;
      html += htmlSegment;
    }
  });
  console.log(html,"html")
  let stageList = document.querySelector('.percentage_student');
  stageList.innerHTML = html;
}

// 6-------------------------------------------------------------------------------
async function renderPercentageIELTS(admissions) {
  console.log(admissions,"admissions")
  let html = '';
  await admissions.map(admission => {
    if (admission.type==="IELTS") {
      let htmlSegment = ` <div class="stageList_item">
                            <input id="${admission.first}_${admission.second}" name="IELTS" class="stageList_item_input" type="radio">
                            <label for="${admission.first}_${admission.second}" class="stageList_item_title">
                                ${admission.firstStatus === "GREATER_OR_EQUAL" ?admission.first + " ≤  " : " < "}
                                score
                                ${admission.secondStatus === "LESS" ? " < " : "  ≤ "}
                                ${admission.second}
                            </label>
                        </div>`;
      html += htmlSegment;
    }
  });
  console.log(html,"html")
  let stageList = document.querySelector('.percentage_IELTS');
  stageList.innerHTML = html;
}

// 7-------------------------------------------------------------------------------
async function renderPercentageSubjectAndArts(subjects,admissions) {
  let subjectHtml = '';
  let artHtml = '';
  await subjects.map(subject => {
    if (subject.science) {
      let htmlSegment = ` <div class="subject_name">${subject.nameEn}:</div>
                                    <div class="subject_grade">
                                     `;
      subjectHtml += htmlSegment;

      admissions.map(admission => {
        if (admission.type==="SUBJECT") {
          let radioSegment = ` <div class="subject_and_art_item">
                            <input id="${admission.first}_${admission.second}_${subject.name}" name=${subject.name} class="stageList_item_input" type="radio">
                            <label for="${admission.first}_${admission.second}_${subject.name}" class="stageList_item_title">
                                ${admission.firstStatus === "GREATER_OR_EQUAL" ?admission.first + " ≤  " : " < "}
                                score
                                ${admission.secondStatus === "LESS" ? " < " : "  ≤ "}
                                ${admission.second}
                            </label>
                        </div>
                    </div>`;
          subjectHtml += radioSegment;
        }
      });



    }
    else {
      let htmlSegment = ` <div class="subject_name">${subject.nameEn}:</div>
                                    <div class="subject_grade">`;
      artHtml += htmlSegment;

      admissions.map(admission => {
        if (admission.type==="SUBJECT") {
          let radioSegment = ` <div class="subject_and_art_item">
                            <input id="${admission.first}_${admission.second}_${subject.name}" name=${subject.name} class="stageList_item_input" type="radio">
                            <label for="${admission.first}_${admission.second}_${subject.name}" class="stageList_item_title">
                                ${admission.firstStatus === "GREATER_OR_EQUAL" ?admission.first + " ≤  " : " < "}
                                score
                                ${admission.secondStatus === "LESS" ? " < " : "  ≤ "}
                                ${admission.second}
                            </label>
                        </div>
                    </div>`;
          artHtml += radioSegment;
        }
      });
    }
  });

  let subjectList = document.querySelector('.subject');
  subjectList.innerHTML = subjectHtml;

  let artList = document.querySelector('.arts');
  artList.innerHTML = artHtml;
}

// 8---------------------------------------------------------
const yesRadio = document.getElementById("stageList_item_yes");
const noRadio = document.getElementById("stageList_item_no");
const descriptionRadio = document.getElementById("school_activities_item_description");

yesRadio.addEventListener("change",(e) => {
  descriptionRadio.classList.add("school_activities_item_description_yes");
})
noRadio.addEventListener("change",(e) => {
  descriptionRadio.classList.remove("school_activities_item_description_yes");
})


// 9--------------------------------------------------------
const impactIds = []
async function renderImpactList(impacts) {
  let html = '';
  await impacts.map(impact => {
    impactIds.push(impact.id);
    let htmlSegment = `<div class="impact_student_item">
                            <input id="${impact.id}" class="stageList_item_input" type="checkbox">
                            <label for="${impact.id}" class="stageList_item_title">${impact.nameEn}</label>
                        </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.impact_student_item_wrapper');
  stageList.innerHTML = html;
}
const impactDescription = document.getElementById("impact_student_item_description");
let impactCheckCounter = 0;
document.body.addEventListener('change', function (e) {
  let target = e.target;
  switch (target.id) {
    case impactIds[0]:
      if (target.checked) {
        impactCheckCounter++;
        console.log(impactCheckCounter)
        impactDescription.classList.add("impact_student_item_description_checked");
      }
      else if (!target.checked){
        impactCheckCounter--;
        if (impactCheckCounter===0){
          impactDescription.classList.remove("impact_student_item_description_checked");
        }
        console.log(impactCheckCounter)
      }
      break;
    case impactIds[1]:
      if (target.checked) {
        impactCheckCounter++;
        console.log(impactCheckCounter)
        impactDescription.classList.add("impact_student_item_description_checked");
      }
      else if (!target.checked){
        impactCheckCounter--;
        if (impactCheckCounter===0){
          impactDescription.classList.remove("impact_student_item_description_checked");
        }
        console.log(impactCheckCounter)
      }
      break;
    case impactIds[2]:
      if (target.checked) {
        impactCheckCounter++;
        console.log(impactCheckCounter)
        impactDescription.classList.add("impact_student_item_description_checked");
      }
      else if (!target.checked){
        impactCheckCounter--;
        if (impactCheckCounter===0){
          impactDescription.classList.remove("impact_student_item_description_checked");
        }
        console.log(impactCheckCounter)
      }
      break;
  }
});

// 10--------------------------------------------------------
let activityInputIds = [];
async function renderActivityList(activities) {
  let html = '';
  await activities.map(activity => {
    activityInputIds.push(`${activity.id}_${activity.nameEn}`);
    let htmlSegment = ` <div class="support_advanced_course">
                            <div class="support_advanced_course_item">
                                <input id="${activity.id}" class="stageList_item_input" type="checkbox">
                                <label for="${activity.id}" class="stageList_item_title">${activity.nameEn}</label>
                            </div>
                            <div id="${activity.id}_${activity.nameEn}" class="support_advanced_course_item support_advanced_course_item_hide">
                                <label for="${activity.id}_" class="stageList_item_title">Please provide an average number of hours per week:</label>
                                <input id="${activity.id}_" class="stageList_item_input" type="text">
                            </div>
                        </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.support_advanced_courses');
  stageList.innerHTML = html;
  console.log(activityInputIds)
}
document.body.addEventListener("change",(e)=>{
  const target = e.target;
  activityInputIds.map(item =>{
    if (item.startsWith(target.id)){
      document.getElementById(item).classList.toggle("support_advanced_course_item_show")
    }
  })
})

// 11--------------------------------------------------------
async function renderSportAward(awards) {
  let html = '';
  await awards.map(award => {
    let htmlSegment = `<div class="sport_award_item">
                            <input id="${award.id}" class="stageList_item_input" type="checkbox">
                            <label for="${award.id}" class="stageList_item_title">${award.nameEn}</label>
                        </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.sport_award');
  stageList.innerHTML = html;
}


// 12--------------------------------------------------------

async function renderSystemList(systems) {
  let html = '';
  await systems.map(system => {
    let htmlSegment = `<div class="system">
                            <input id="${system.id}" name="system" class="stageList_item_input" type="radio">
                            <label for="${system.id}" class="stageList_item_title">${system.nameEn}</label>
                        </div>`;
    html += htmlSegment;
  });
  let stageList = document.querySelector('.systems');
  stageList.innerHTML = html;
}

const body= {
  schoolDetailReqDTO: {
    schoolName: "Press School2",
    address:{
      lan: 58.4,
      lat: 91.7
    },
    website: "www.presidentSchool.uz",
    phoneNumber: "+998996280122",
    email: "press2@gmail.com",
    systemId: 4,
    districtId: 10,
    graduationRate: 89.9,
    studentTeacher: 24,
    studentClass: 26
  },
  awardsId:[
    1, 3
  ],
  stages: [
    {
      id: "d9f786ce-787d-4c5c-ba0b-c64399d80b72",
      count: 60
    },
    {
      id: "7af18bda-6500-4138-878e-e38ffa1b9364",
      count: 78
    },
    {
      id: "02b8bbb3-83db-4564-9eb2-29cb78660ef9",
      count: 56
    }
  ],
  tests:[
    {
      id: 1,
      markId: 1,
      participationRate: 90.6
    },
    {
      id : 2,
      average : 1440,
      participationRate : 98.2
    }
  ],
  markAdmissionId : 5,
  subjects :[
    {
      id : "f061f7d7-3979-448c-93d0-a44b91135cc3",
      markId: 7
    },
    {
      id: "9f4d9f06-f29b-41c3-a901-5e0adf6425bd",
      markId: 4
    }
  ],
  activities:[
    {
      id: "b98b25a2-21c8-4e9b-bed7-d58968a45c3a",
      hour: 10.5
    },
    {
      id: "128d1955-a2fb-45a4-a1bf-437b8f9c6a2f",
      hour: 3
    }
  ],
  impacts:[
    {
      id: "b6f9631d-e829-49a1-aa27-91b8eb806fde",
      description: "Great"
    },
    {
      id: "a053349a-6822-45fd-9ea5-f3cb1510202b",
      description: "Excellent"
    }

  ],
  sportFacilities:[
    "c714accf-50e1-4188-bf34-39297187c365",
    "c772d10e-8904-4ccc-b930-fd635bf19331"
  ]
}

