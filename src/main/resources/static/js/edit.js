// 获取 URL 查询参数中的学生 ID
const params = new URLSearchParams(window.location.search);

const studentId = params.get('id');

// 如果有 ID，获取学生数据并填充表单
if (studentId) {
    fetch(`/api/students/${studentId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Failed to fetch student: ${response.statusText}`);
            }
            return response.json();
        })
        .then(student => {
            // 填充表单数据
            document.getElementById('name').value = student.name;
            document.getElementById('age').value = student.age;
            document.getElementById('grade').value = student.grade;
        })
        .catch(error => {
            console.error('Error fetching student:', error);
        });
}

// 处理保存操作
document.getElementById('saveButton').addEventListener('click', () => {
    const updatedData = {
        name: document.getElementById('name').value,
        age: parseInt(document.getElementById('age').value, 10),
        grade: document.getElementById('grade').value,
    };

    fetch(`/api/students/${studentId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedData),
    })
        .then(response => {
            if (response.ok) {
                alert('Student updated successfully');
                window.location.href = 'index.html'; // 跳转回主页面或学生列表页面
            } else {
                throw new Error(`Failed to update student: ${response.statusText}`);
            }
        })
        .catch(error => {
            console.error('Error updating student:', error);
        });
});
