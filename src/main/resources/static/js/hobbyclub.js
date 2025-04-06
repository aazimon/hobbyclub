function doubler(str, character) {
   return str.replace(new RegExp(character, 'g'), character + character);
}

function activateStateCity() {
   document.getElementById('stateId').addEventListener('change', function () {
      const stateId = this.value;
      if (stateId) {
         let url = `/ajax/cities/${stateId}`
         fetch(url).then(response => response.json())
                 .then(results => {
                    let cities = Object.assign({}, {cities: results});
                    let template = document.getElementById('cityTemplate').innerHTML;
                    template = doubler(template, '{');
                    template = doubler(template, '}');
                    const rendered = Mustache.render(template, cities);
                    document.getElementById('cityId').innerHTML = rendered;
                 })
                 .catch(error => console.error('Error retrieving Cities for StateId: ${stateId}', error));
      } else {
         document.getElementById('cityId').innerHTML = '<option value="">Any</option>';
      }
   });
}
