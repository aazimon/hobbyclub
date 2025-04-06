document.getElementById('stateId').addEventListener('change', function () {
   const stateId = this.value;
   if (stateId) {
      let url = '/ajax/cities/${stateId}'
      fetch(url).then(response => response.json())
              .then(cities => {
                 let base = document.getElementById('cityTemplate').innerHTML;
                 base = doubler(base, '{');
                 const template = doubler(base, '}');
                 const rendered = Mustache.render(template, {cities: cities});
                 document.getElementById('cityId').innerHTML = rendered;
              })
              .catch(error => console.error('Error retrieving Cities for StateId: ${stateId}', error));
   } else {
      document.getElementById('cityId').innerHTML = '<option value="">Any</option>';
   }
});

