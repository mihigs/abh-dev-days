import Controller from "@ember/controller";
import { inject as service } from "@ember/service";

export default Controller.extend({
  ajax: service('ajax'),

  actions: {
    deleteCuisine() {
      this.get('ajax').del('/admin/deleteCuisine/' + this.get('model.cuisine.id'), {
        xhrFields: {
          withCredentials: true,
        },
      })
      .then(
        () => this.transitionToRoute('admin.cuisines'),
        () => alert('You can not delete a Cuisine that is a assinged to a Restaurant. Please remove if from all restaurants before proceeding'));
    },
  },
});
