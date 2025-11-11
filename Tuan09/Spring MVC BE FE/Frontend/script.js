const API_BASE_URL = 'http://localhost:8081/api/employee';
const tableBody = document.getElementById('employee-table-body');

async function fetchEmployees() {
    try {
        const response = await fetch(API_BASE_URL);
        const employees = await response.json();
        renderEmployees(employees);
    } catch (error) {
        console.error('Error fetching employees:', error);
        alert('Could not load employee data. Is the Backend running on port 8081?');
    }
}

async function deleteEmployee(id) {
    if (!confirm(`Are you sure you want to delete employee ID: ${id}?`)) return;

    try {
        const response = await fetch(`${API_BASE_URL}/${id}`, { method: 'DELETE' });
        if (response.ok) {
            alert(`Employee ID ${id} deleted successfully.`);
            fetchEmployees(); // Refresh the list
        } else {
            throw new Error(`Failed to delete! Status: ${response.status}`);
        }
    } catch (error) {
        console.error('Error deleting employee:', error);
        alert('Error deleting employee.');
    }
}

async function saveOrUpdateEmployee(event) {
    event.preventDefault();

    const id = document.getElementById('employee-id').value;
    const isUpdate = id !== "";

    const employeeData = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        email: document.getElementById('email').value,
        dateOfBirth: document.getElementById('dateOfBirth').value, // Chú ý format dateOfBirth
        phone: document.getElementById('phone').value,
        gender: document.querySelector('input[name="gender"]:checked').value,
        address: document.getElementById('address').value,
    };

    if (isUpdate) {
        employeeData.id = parseInt(id);
    }

    try {
        const response = await fetch(isUpdate ? `${API_BASE_URL}/${id}` : API_BASE_URL, {
            method: isUpdate ? 'PUT' : 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(employeeData),
        });

        if (response.ok) {
            alert(`Employee ${isUpdate ? 'updated' : 'added'} successfully!`);
            window.location.href = 'index.html';
        } else {
            const error = await response.text();
            throw new Error(error || `Failed to ${isUpdate ? 'update' : 'add'} employee.`);
        }
    } catch (error) {
        console.error('Error saving employee:', error);
        alert('Error saving employee: ' + error.message);
    }
}

function renderEmployees(employees) {
    tableBody.innerHTML = '';
    employees.forEach(emp => {
        const row = tableBody.insertRow();

        row.insertCell().textContent = emp.firstName;
        row.insertCell().textContent = emp.lastName;
        row.insertCell().textContent = emp.gender;
        row.insertCell().textContent = emp.dateOfBirth;
        row.insertCell().textContent = emp.email;
        row.insertCell().textContent = emp.phone;

        const actionsCell = row.insertCell();
        actionsCell.className = 'action';

        const updateLink = document.createElement('a');
        updateLink.textContent = 'Update';
        updateLink.href = `employee-form.html?id=${emp.id}`;

        const deleteLink = document.createElement('a');
        deleteLink.textContent = ' | Delete';
        deleteLink.href = "#";
        deleteLink.onclick = (e) => { e.preventDefault(); deleteEmployee(emp.id); };

        actionsCell.appendChild(updateLink);
        actionsCell.appendChild(deleteLink);
    });
}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

async function initForm() {
    const id = getUrlParameter('id');
    const form = document.getElementById('employee-form');
    form.addEventListener('submit', saveOrUpdateEmployee);

    if (id) {
        // Update mode
        document.getElementById('form-title').textContent = "UPDATE EMPLOYEE";
        document.getElementById('submit-button').textContent = "Update";

        try {
            const response = await fetch(`${API_BASE_URL}/${id}`);
            const emp = await response.json();

            document.getElementById('employee-id').value = emp.id;
            document.getElementById('firstName').value = emp.firstName;
            document.getElementById('lastName').value = emp.lastName;
            document.getElementById('email').value = emp.email;
            document.getElementById('dateOfBirth').value = emp.dateOfBirth;
            document.getElementById('phone').value = emp.phone;
            document.getElementById('address').value = emp.address;

            // Set radio button
            if (emp.gender === 'Female') {
                document.getElementById('gender-female').checked = true;
            } else {
                document.getElementById('gender-male').checked = true;
            }

        } catch (error) {
            console.error('Error loading employee for update:', error);
            alert('Error loading employee data.');
            window.location.href = 'index.html';
        }
    } else {
    }
}

function searchEmployee() {
    alert("Search functionality requires a backend API. Currently, it's just a placeholder.");
    // const keyword = document.getElementById('search-input').value.toLowerCase();
    // fetch(`${API_BASE_URL}/search?keyword=${keyword}`).then(resp => resp.json()).then(renderEmployees);
}