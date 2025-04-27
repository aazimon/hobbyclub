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

function validateNewEvent() {
   document.getElementById('invalidTitle').innerHTML = '';
   document.getElementById('invalidDetails').innerHTML = '';
   document.getElementById('invalidDate').innerHTML = '';
   document.getElementById('invalidState').innerHTML = '';
   document.getElementById('invalidCity').innerHTML = '';
   var title = document.getElementById('newEventTitle').value.trim();
   var details = document.getElementById('newEventDetails').value.trim();
   var dateTime = document.getElementById('newEventDate').value.trim();
   var state = document.getElementById('stateId').value.trim();
   var city = document.getElementById('cityId').value.trim();
   var valid = true;

   if (!title) {
      document.getElementById('invalidTitle').innerHTML = '<p class="error">A Title is Required</p>';
      valid = false;
   }
   if (!details) {
      document.getElementById('invalidDetails').innerHTML = '<p class="error">Details are Required</p>';
      valid = false;
   }
   if (!dateTime) {
      document.getElementById('invalidDate').innerHTML = '<p class="error">Details are Required</p>';
      valid = false;
   }
   if (!state) {
      document.getElementById('invalidState').innerHTML = '<p class="error">State is Required</p>';
      valid = false;
   }
   if (!city) {
      document.getElementById('invalidCity').innerHTML = '<p class="error">City is Required</p>';
      valid = false;
   }
   return valid;
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
      let url = `/ajax/validateClub/${title}`;
      fetch(url).then(response => {
         if (!response.ok) {
            document.getElementById('invalidTitle').innerHTML = '<p class="error">Club name is already taken. Please choose another.</p>';
         } else {
            // submit form.
            var club = {
               title: title,
               category: category,
               description: description
            };
            saveNewClub(club);
         }
      }).catch(error => {
         console.error('Error validating Club Title', error);
         document.getElementById('invalidTitle').innerHTML = '<p class="error">Unexpected Error. Please Try again later.</p>';
      });
   }
}

function saveNewClub(club) {
   let url = `/ajax/saveClub`;
   $.ajax({
      type: "POST",
      url: url,
      contentType: "application/json",
      data: JSON.stringify(club),
      success: function (data) {
         let base = document.getElementById('yourClubTemplate').innerHTML;
         base = doubler(base, '{');
         const template = doubler(base, '}');
         const rendered = Mustache.render(template, {club: data});
         document.getElementById('yourClubList').innerHTML += rendered;
         var modalEl = document.getElementById('newClub');
         var modalInst = bootstrap.Modal.getInstance(modalEl);

         document.getElementById('newClubTitle').value = '';
         document.getElementById('newClubCategory').selectedIndex = 0;
         document.getElementById('newClubDescription').value = '';
         modalInst.hide();
      },
      error: function (data) {
         console.error('Error saving Club', data);
         document.getElementById('invalidTitle').innerHTML = '<p class="error">Unexpected Error. Please Try again later.</p>';
      }
   });
}
