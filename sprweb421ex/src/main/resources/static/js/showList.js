import * as tools from './fetchTools.js';

const containerElement = document.querySelector("#container");

/**
 * 상품 리스트 하나의 구성 예상도
 * <div class="sangpums">
        <img src="..." alt="...">
        <ul class="info">
            <li><span>상품명 : </span> <span>(상품명)</span> </li>
            <li><span>수량 : </span> <span>(수량)</span> </li>
            <li><span>단가 : </span> <span>(단가)</span> </li>
            <li><span>상세설명 : </span> <span class="details">(상세설명)</span> </li>
            <li><span>업로드 날짜: </span> <span>(업로드날짜)</span> </li>
        </ul>
    </div>
 * 
 * @param {Object} data - fetch() 함수에서 서버로부터 받아온 JSON 형태 데이터
 */
function addSangpumList(data) {

    /**
     * 한 개의 li 요소 생성
     * 
     * @param {String} fieldName - 필드명
     * @param {*} data - 특정 데이터
     * @param {String | null} className - class 속성에 들어갈 값. 없으면 null
     * @returns {HTMLLIElement}
     */
    function liElementFactory(fieldName, data, className) {
        let liElement = document.createElement("li");

        let titleSpan = document.createElement("span");
        titleSpan.textContent = fieldName;
        liElement.appendChild(titleSpan);

        let dataSpan = document.createElement("span");
        if (className !== null) {
            dataSpan.classList.add(className);
        }
        dataSpan.textContent = data;
        liElement.appendChild(dataSpan);

        return liElement;
    }

    for (let oneData of data) {
        let sangpumOneListElement = document.createElement("div");
        sangpumOneListElement.classList.add("sangpums");

        let imgElement = document.createElement("img");
        imgElement.setAttribute("src", oneData.filepath);
        imgElement.setAttribute("alt", oneData.sangdataDto.sang);
        sangpumOneListElement.appendChild(imgElement);

        let ulElement = document.createElement("ul");
        ulElement.classList.add("info");
        
        ulElement.appendChild(liElementFactory("상품명 : ", oneData.sangdataDto.sang, null));
        ulElement.appendChild(liElementFactory("수량 : ", oneData.sangdataDto.su, null));
        ulElement.appendChild(liElementFactory("단가 : ", oneData.sangdataDto.dan, null));
        ulElement.appendChild(liElementFactory("상세설명 : ", oneData.about, "details"));
        ulElement.appendChild(liElementFactory("업로드 날짜 : ", oneData.uploadat.split("T").join(" "), null));
        sangpumOneListElement.appendChild(ulElement);

        containerElement.appendChild(sangpumOneListElement);
    }
}

function showIfError(errorMsg) {
    containerElement.innerHTML = errorMsg;
}

document.addEventListener("DOMContentLoaded", event => {
    let requestOptions = {
        uri: `/api/sangpum`,
        options : {
            method: 'GET'
        }
    };
    tools.fetchAndShow(requestOptions, addSangpumList, showIfError);
});