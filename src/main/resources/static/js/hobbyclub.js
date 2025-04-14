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

function validateNewClub() {
   document.getElementById('invalidTitle').innerHTML = '';
   document.getElementById('invalidCategory').innerHTML = '';
   document.getElementById('invalidDescription').innerHTML = '';
   var title = document.getElementById('newClubTitle').value.trim();
   var category = document.getElementById('newClubCategory').value;
   var description = document.getElementById('newClubDescription').value.trim();
   var valid = true;

   if (!description) {
      // no description
      document.getElementById('invalidDescription').innerHTML = '<p class="error">A Description is Required</p>';
      valid = false;
   }
   if (!category) {
      // no Category Selected
      document.getElementById('invalidCategory').innerHTML = '<p class="error">A Category must be Selected</p>';
      valid = false;
   }
   if (!title) {
      // no title
      document.getElementById('invalidTitle').innerHTML = '<p class="error">A Title is Required</p>';
      valid = false;
   }
   if (valid) {
      // check for duplicate Title per State, base on Logged in User's State
      let url = `/ajax/newClub/${title}`
      fetch(url).then(response => response.json())
              .then(results => {
                 let answer = Object.assign({}, {answer: results});
                 if (answer === "valid") {
                    // submit form.
                 } else {
                    document.getElementById('invalidTitle').innerHTML = '<p class="error">Club name is already taken. Please choose another.</p>';
                 }
              })
              .catch(error => console.error('Error validationg Club Title', error));
   }

}

