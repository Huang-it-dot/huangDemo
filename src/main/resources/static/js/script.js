document.addEventListener('DOMContentLoaded', function() {
	fetchStudents();
	// 添加学生
	document.getElementById('add-student-form').addEventListener('submit', function(e) {
		e.preventDefault();
		const name = document.getElementById("name").value;
		const email = document.getElementById("email").value;
		const age = document.getElementById("age").value;

		// 创建一个学生对象
		const studentData = {
			name: name,
			email: email,
			age: age
		};

		fetch('/api/addStudent', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(studentData) // 将数据转换为 JSON 格式
		})
			.then(response => response.json())
			.then(data => displayStudents(data))
			.catch(error => console.error('Error:', error));
	});

	// 获取所有学生并显示
	function fetchStudents() {
		fetch('/api/students')
			.then(response => response.json())
			.then(students => displayStudents(students))
			.catch(error => console.error('Error:', error));
	}

	// 显示学生数据
	function displayStudents(students) {
		const listElement = document.getElementById('student-list');
		listElement.innerHTML = "";

		students.forEach(student => {
			const row = document.createElement('tr');
			row.innerHTML = `
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.age}</td>
                <td>
                    <button onclick="editStudent(${student.id})">Edit</button>
                    <button onclick="deleteStudent(${student.id})">Delete</button>
                </td>
            `;
			listElement.appendChild(row);
		});
	}

	function addStudents(student) {
		const listElement = document.getElementById('student-list');

		const row = document.createElement('tr');
		row.innerHTML = `
	               <td>${student.id}</td>
	               <td>${student.name}</td>
	               <td>${student.email}</td>
	               <td>${student.age}</td>
	               <td>
	                   <button onclick="editStudent(${student.id})">Add</button>
	                   <button onclick="deleteStudent(${student.id})">Delete</button>
	               </td>
	           `;
		listElement.appendChild(row);
	}
});

// 编辑学生
function editStudent(id) {
    // 获取指定 ID 的学生数据
    fetch(`/api/students/${id}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Failed to fetch student: ${response.statusText}`);
            }
            return response.json(); // 将响应体解析为 JSON
        })
        .then(student => {
            console.log('Fetched student:', student);
            // 在这里处理获取到的学生数据，例如显示在表单中供用户编辑
            window.location.href = `/edit/${id}`;
			//window.location.reload();
        })
        .catch(error => {
            console.error('Error fetching student:', error);
        });
}


// 删除学生
function deleteStudent(id) {
	fetch(`/edit/${id}`, {
	     method: 'DELETE'
	 })
	 .then(response => {
	     if (response.ok) {
		//刷新当前页面
	    window.location.reload();
	     } else {
	         console.error('Failed to delete student');
	     }
	 })
	 .catch(error => console.error('Error:', error));
}
// 获取单个学生
function getStudentById(id) {
	fetch(`/api/students/${id}`)
		.then(response => response.json())
		.then(data => data)
		.catch(error => console.error('Error:', error));
}