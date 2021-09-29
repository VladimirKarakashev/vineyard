const date = new Date();

const renderCalendar = () => {
  date.setDate(1);

  const monthDays = document.querySelector(".days");

  const lastDay = new Date(
    date.getFullYear(),
    date.getMonth() + 1,
    0
  ).getDate();

  const prevLastDay = new Date(
    date.getFullYear(),
    date.getMonth(),
    0
  ).getDate();

  const firstDayIndex = date.getDay() - 1;

  const lastDayIndex = new Date(
    date.getFullYear(),
    date.getMonth() + 1,
    0
  ).getDay();

  const nextDays = lastDayIndex;

  const months = ["Януари", "Февруари", "Март", "Април", "Май", "Юни",
    "Юли", "Август", "Септември", "Октомври", "Ноември", "Декември"];

  document.querySelector(".date h1").innerHTML = months[date.getMonth()];

  document.querySelector(".date p").innerHTML = new Date().toLocaleString("bg-BG");

  let days = "";

  for (let x = firstDayIndex; x > 0; x--) {
    switch (firstDayIndex) {
        case '0': days += `<div class="prev-date">${prevLastDay - x + 6}</div>`;
        default: days += `<div class="prev-date">${prevLastDay - x + 1}</div>`;
    }
  }

  for (let i = 1; i <= lastDay; i++) {
    if (
      i === new Date().getDate() &&
      date.getMonth() === new Date().getMonth()
    ) {
      days += `<div class="today">${i}</div>`;
    } else {
      days += `<div class="day">${i}</div>`;
    }
  }

  for (let j = 1; j <= nextDays; j++) {
    days += `<div class="next-date">${j}</div>`;
  }

  monthDays.innerHTML = days;

};

document.querySelector(".prev").addEventListener("click", () => {
  date.setMonth(date.getMonth() - 1);
  renderCalendar();

});

document.querySelector(".next").addEventListener("click", () => {
  date.setMonth(date.getMonth() + 1);
  renderCalendar();

});

renderCalendar();

function clearFilter() {
    window.location = '/operations';
};

function showStats() {
    var sbtn = document.getElementById("statbtn");
    var stat = document.getElementById("stats");
    if (stat.style.display === "none") {
        stat.style.display = "block";
        sbtn.value = "Скрий Стат.";
    } else {
        stat.style.display = "none";
        sbtn.value = "Статистика";
    }
};