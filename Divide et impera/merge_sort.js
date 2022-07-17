const merge = (left, right) => {
	let arr = [];
	// Break out of loop if any one of the array gets empty
	while (left.length && right.length) {
		// Pick the smaller among the smallest element of left and right sub arrays
		// with shift function the 0^ element gets removed from the array after being pushed
		if (left[0] < right[0]) {
			arr.push(left.shift());
		} else {
			arr.push(right.shift());
		}
	}

	// Concatenating the leftover elements
	// (in case we didn't go through the entire left or right array)
	return [...arr, ...left, ...right];
};

const mergeSort = (array) => {
	// Base case or terminating case
	if (array.length < 2) {
		return array;
	}

	// splice left part of array and the remaning part is still in array (-> right)
	const left = array.splice(0, array.length / 2);

	return merge(mergeSort(left), mergeSort(array));
};

let arr = [8, 2, 4, 1, 3];
let sorted_arr = mergeSort(arr);
console.log(sorted_arr);
