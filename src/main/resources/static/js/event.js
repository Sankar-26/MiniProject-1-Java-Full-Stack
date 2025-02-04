  function viewEmployee(employeeId) {
    fetch(`/display-employee?id=${employeeId}`)
      .then(response => response.json())
      .then(data => {
        alert(`Name: ${data.name}\nPosition: ${data.position}\nEmail: ${data.email}`);
      })
      .catch(error => {
        alert('Error loading employee details.');
      });
  }