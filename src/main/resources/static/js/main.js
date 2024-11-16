// JavaScript for Delete Button
function deleteUser() {
    const confirmation = confirm("Are you sure you want to delete this user?");
    if (confirmation) {
        // Redirect to delete action
        window.location.href = '/deleteUser?id=12345';
    }
}