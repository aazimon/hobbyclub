document.getElementById('stateId').addEventListener('change', function () {
   const stateId = this.value;
   if (stateId) {
      fetch('/ajax/cities/${stateId}').then(response => response.json())
              .then(cities => {
                 const template = document.getElementById('cityTemplate').innerHTML;
                 const rendered = Mustache.render(template, {cities: cities});
                 document.getElementById('cityId').innerHTML = rendered;
              })
              .catch(error => console.error('Error retrieving Cities for StateId: ${stateId}', error));
   } else {
      document.getElementById('cityId').innerHTML = '<option value="">Any</option>';
   }
});

