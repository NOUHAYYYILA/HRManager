document.addEventListener('DOMContentLoaded', function() {
    const employeesTableBody = document.querySelector('#employees-table tbody');
    const addEmployeeForm = document.getElementById('add-employee-form');
    const searchInput = document.getElementById('search');

    function addEmployeeToTable(lastName, firstName, email, position) {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${lastName}</td>
            <td>${firstName}</td>
            <td>${email}</td>
            <td>${position}</td>
            <td>
                <button class="edit-btn">Modifier</button>
                <button class="delete-btn">Supprimer</button>
            </td>
        `;
        employeesTableBody.appendChild(row);

        row.querySelector('.edit-btn').addEventListener('click', () => editEmployee(row));
        row.querySelector('.delete-btn').addEventListener('click', () => deleteEmployee(row));
    }

    function editEmployee(row) {
        const lastName = row.children[0].textContent;
        const firstName = row.children[1].textContent;
        const email = row.children[2].textContent;
        const position = row.children[3].textContent;

        document.getElementById('last-name').value = lastName;
        document.getElementById('first-name').value = firstName;
        document.getElementById('email').value = email;
        document.getElementById('position').value = position;

        deleteEmployee(row);
    }

    function deleteEmployee(row) {
        employeesTableBody.removeChild(row);
    }

    addEmployeeForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const lastName = document.getElementById('last-name').value;
        const firstName = document.getElementById('first-name').value;
        const email = document.getElementById('email').value;
        const position = document.getElementById('position').value;

        addEmployeeToTable(lastName, firstName, email, position);
        addEmployeeForm.reset();
    });

    searchInput.addEventListener('input', function() {
        const searchTerm = searchInput.value.toLowerCase();
        const rows = employeesTableBody.querySelectorAll('tr');
        rows.forEach(row => {
            const cells = row.querySelectorAll('td');
            const matches = Array.from(cells).some(cell => cell.textContent.toLowerCase().includes(searchTerm));
            row.style.display = matches ? '' : 'none';
        });
    });

    // Exemple d'employés existants
    addEmployeeToTable('Dupont', 'Alice', 'alice.dupont@example.com', 'Développeur');
    addEmployeeToTable('Martin', 'Bob', 'bob.martin@example.com', 'Designer');
});
