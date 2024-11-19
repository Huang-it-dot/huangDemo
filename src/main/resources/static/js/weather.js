/*const select = document.querySelector("select");

const para = document.getElementById("weather-message");

select.addEventListener("change", setWeather);

function setWeather() {
  const choice = select.value;

  if (choice === "sunny") {
	
    para.textContent =
      "今日はとてもいい天気です。半ズボンをはいて、砂浜や公園に出かけ、アイスクリームを食べましょう！";
  } else if (choice === "rainy") {
    para.textContent =
      "外は雨が降っています。レインコートと傘を忘れないようにして、できる限り室内で過ごしましょう。";
  } else if (choice === "snowing") {
    para.textContent =
      "雪が降ってとても寒いです！室内でホットチョコレートを飲むか、雪だるまを作るのがよいでしょう。";
  } else if (choice === "overcast") {
    para.textContent =
      "雨は降っていませんが、空はとても暗くなっています。万が一に備えレインコートを持っていきましょう。";
  } else {
    para.textContent = "";
  }
} */
  // 获取 select 元素
  const dropdown = document.getElementById("searchable-dropdown");

  // 发送请求到后端
  fetch("/api/weather")
    .then((response) => response.json()) // 将响应解析为 JSON
    .then((data) => {
      // 清空下拉框内容
      dropdown.innerHTML = "";

      // 遍历返回的数据，动态创建 option 元素
      data.forEach((item) => {
        const option = document.createElement("option");
        option.value = item.value; // 设置 value 属性
        option.textContent = item.text; // 设置显示的文本
        dropdown.appendChild(option); // 添加到 select 元素中
      });
    })
    .catch((error) => {
      console.error("加载数据失败：", error);
      dropdown.innerHTML = '<option value="">加载失败</option>';
    });
