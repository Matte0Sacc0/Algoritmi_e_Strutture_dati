const swap = (array, leftIndex, rightIndex) => {
	let temp = array[leftIndex];
	array[leftIndex] = array[rightIndex];
	array[rightIndex] = temp;
};

const partition = (array, left, right) => {
	let pivot = array[Math.floor((right + left) / 2)], //middle element
		i = left, //left pointer
		j = right; //right pointer

	while (i <= j) {
		while (array[i] < pivot) {
			i++;
		}
		while (array[j] > pivot) {
			j--;
		}
		if (i <= j) {
			swap(array, i, j); //sawpping two elements
			i++;
			j--;
		}
	}
	return i;
};

const quickSort = (array, left, right) => {
	let index;

	if (array.length > 1) {
		index = partition(array, left, right); //index returned from partition
		if (left < index - 1) {
			//more elements on the left side of the pivot
			quickSort(array, left, index - 1);
		}
		if (index < right) {
			//more elements on the right side of the pivot
			quickSort(array, index, right);
		}
	}

	return array;
};

let arr = [8, 2, 4, 1, 3];
console.log(arr);
let sorted_arr = quickSort(arr, 0, arr.length - 1);
console.log(sorted_arr);
