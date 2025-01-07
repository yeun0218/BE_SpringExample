// 조회
function getProduct() {
	fetch("/products", {
		method:"GET"
	})
	.then(response => {
		if(!response.ok) {
			throw new Error("네트워크 오류");
		}
		return response.json();
	})
	.then(list => {
		const products = list.products;
		displayProduct(products);
	})
	.catch(error => {
		console.log("데이터 읽기 오류 : " + error);
	});
}

//상품
function displayProduct(products) {
	let tableBody = document.querySelector("#tableBody");
	tableBody.innerHTML = "";
	
	products.forEach(product => {
		let row = document.createElement("tr");
		row.innerHTML = `
			<td>${product.code}</td>
			<td>${product.sang}</td>
			<td>${product.su}</td>
			<td>${product.dan}</td>
			<td>
				<a href="#" onclick="updateProduct1(${product.code})">수정</a>
			</td>
			<td>
				<a href="#" onclick="deleteProduct(${product.code})">삭제</a>
			</td>`;
		tableBody.appendChild(row)
	});
}

// 추가
function insertProduct() {
	const form = document.querySelector("#insertFrm");
	const formData = new FormData(form);
	fetch("/products", {
		method:"POST",
		body:formData
	})
	.then(response => {
		if(!response.ok) {
			throw new Error("상품 추가 실패");	
		}
		return response.json();
	})
	.then(data => {
		if(data.Success) {
			getProduct(); // 추가 후 목록 보기
		}
	})
	.catch(error => {
		console.log("오류 : " + error);
	});
}

//상품 추가 폼
function displayProduct2() {
	let showData = document.querySelector("#showData");
	showData.innerHTML = "";
	
    const form = document.createElement("form");
    form.id = "insertFrm";

    form.innerHTML = `
    * 상품 추가 *<br>
	코드 : <input type="text" name="code"><br>
	품명 : <input type="text" name="sang"><br>
	수량 : <input type="text" name="su"><br>
	단가 : <input type="text" name="dan"><br>
	<input type="submit" value="추가">
    `;
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        insertProduct();
    });
    showData.appendChild(form);
}

// 수정
function updateProduct() {
	//alert("a");
	const form = document.querySelector("#updateFrm");
	const formData = new FormData(form);
	
	const code = formData.get("code");
    const sang = formData.get("sang");
    const su = formData.get("su");
    const dan = formData.get("dan");

	fetch("/products", {
		method:"PUT",
		headers:{
			"Content-Type":"application/json"
		},
		body:JSON.stringify({code:code,sang:sang,su:su,dan:dan})
	})
	.then(response => {
		if(!response.ok) {
			throw new Error("상품 수정 실패");	
		}
		return response.json();
	})
	.then(data => {
		if(data.Success) {
			getProduct(); // 수정 후 목록 보기
		}
	})
	.catch(error => {
		console.log("오류 : " + error);
	});
}

//수정 자료 읽어 오기
function updateProduct1(code) {
	fetch(`/products/${code}`, {
		method:"GET"
	})
	.then(response => {
		if(!response.ok) {
			throw new Error("네트워크 오류");
		}
		return response.json();
	})
	.then(update => {
		displayProduct1(update);
	})
	.catch(error => {
		console.log("데이터 읽기 오류 : " + error);
	});
}

//상품 수정 폼
function displayProduct1(product) {
	let showData = document.querySelector("#showData");
	showData.innerHTML = "";
	
    const form = document.createElement("form");
    form.id = "updateFrm";

    form.innerHTML = `
    * 상품 수정 *<br>
	코드 : <input type="text" name="code" value="${product.code}" readonly><br>
	품명 : <input type="text" name="sang" value="${product.sang}"><br>
	수량 : <input type="text" name="su" value="${product.su}"><br>
	단가 : <input type="text" name="dan" value="${product.dan}"><br>
	<input type="submit" value="수정">
    `;
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        updateProduct();
    });
    showData.appendChild(form);
}

// 삭제
function deleteProduct(code) {
	//alert(num);
	if(confirm("정말 삭제할까나?")) {
		fetch(`/products/${code}`, {
			method:"DELETE"
		})
		.then(response => {
			if(!response.ok) {
				throw new Error("네트워크 오류");
			}
			getProduct(); // 삭제 후 목록 보기
		})
		.catch(error => {
			console.log("삭제 오류 : " + error);
		});
	}
}