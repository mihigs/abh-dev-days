import { helper } from '@ember/component/helper';

function filterRestaurant(args) {
  let restaurant = args[0];
  console.log(restaurant)
  console.log(args)
  
  
  if(args[1] !== '' && args[1] !== restaurant.name) return false;
  if(args[4] !== null && args[4] > restaurant.priceRange) return false;
  if(args[5] !== null && args[5] > restaurant.averageRating) return false;

  if(args[3] !== ""){
    if(restaurant.cuisines.length === 0) return false;
    let flag = false;
    let cuisines = args[3].split(',');
    console.log(cuisines)
    restaurant.cuisines.forEach(restCuisine => {
      if(args[3] === restCuisine){
        flag = true;
      }
    });
    if(!flag) return false;
  }
  return true;
}

export default helper(filterRestaurant);