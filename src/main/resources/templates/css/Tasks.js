document.addEventListener('DOMContentLoaded', function() {
    // Sélectionner le corps de la table des tâches
    const tasksTableBody = document.querySelector('#tasks-table tbody');
    // Sélectionner le formulaire d'assignation de tâche
    const assignTaskForm = document.getElementById('assign-task-form');

    // Fonction pour ajouter une nouvelle tâche à la table
    function addTaskToTable(taskName, employeeName, taskStatus) {
        // Créer une nouvelle ligne de table
        const row = document.createElement('tr');

        // Ajouter le contenu de la ligne
        row.innerHTML = `
            <td>${taskName}</td>
            <td>${employeeName}</td>
            <td>${taskStatus}</td>
            <td>
                <button class="edit-btn">Modifier</button>
                <button class="delete-btn">Supprimer</button>
            </td>
        `;

        // Ajouter la nouvelle ligne au corps de la table
        tasksTableBody.appendChild(row);

        // Ajouter des écouteurs d'événements aux boutons Modifier et Supprimer
        row.querySelector('.edit-btn').addEventListener('click', () => editTask(row));
        row.querySelector('.delete-btn').addEventListener('click', () => deleteTask(row));
    }

    // Fonction pour éditer une tâche
    function editTask(row) {
        // Récupérer les valeurs de la ligne
        const taskName = row.children[0].textContent;
        const employeeName = row.children[1].textContent;
        const taskStatus = row.children[2].textContent;

        // Remplir le formulaire avec les valeurs récupérées
        document.getElementById('task-name').value = taskName;
        document.getElementById('employee-name').value = employeeName;
        document.getElementById('task-status').value = taskStatus;

        // Supprimer la tâche de la table pour permettre la mise à jour
        deleteTask(row);
    }

    // Fonction pour supprimer une tâche
    function deleteTask(row) {
        // Supprimer la ligne de la table
        tasksTableBody.removeChild(row);
    }

    // Gérer la soumission du formulaire de nouvelle tâche
    assignTaskForm.addEventListener('submit', function(e) {
        // Empêcher le comportement par défaut du formulaire (rechargement de la page)
        e.preventDefault();

        // Récupérer les valeurs du formulaire
        const taskName = document.getElementById('task-name').value;
        const employeeName = document.getElementById('employee-name').value;
        const taskStatus = document.getElementById('task-status').value;

        // Ajouter la nouvelle tâche à la table
        addTaskToTable(taskName, employeeName, taskStatus);

        // Réinitialiser le formulaire
        assignTaskForm.reset();
    });

    // Exemple de tâches existantes (vous pouvez les supprimer ou les modifier)
    addTaskToTable('Préparer le rapport mensuel', 'Alice Dupont', 'en cours');
    addTaskToTable('Mettre à jour le site web', 'Bob Martin', 'en attente');
});
