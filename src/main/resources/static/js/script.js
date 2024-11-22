document.addEventListener('DOMContentLoaded', function() {
    fetchStudents();

    // 添加学生
    document.getElementById('add-student-form').addEventListener('submit', function(e) {
        e.preventDefault();
        const formData = new FormData(this);
        fetch('/api/students', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => addStudentToTable(data))
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

    // 编辑学生
    function editStudent(id) {
        const student = getStudentById(id);
        if (!student) return;

        // 在这里实现编辑逻辑
        console.log('Editing student:', student);
    }

    // 删除学生
    function deleteStudent(id) {
        fetch(`/api/students/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                fetchStudents(); // 重新获取学生列表
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
});