import { createSlice } from "@reduxjs/toolkit";

const ResourceSlice = createSlice({
    name:"resource",
    initialState:{
        name:"",
        weight:0,
        calorie:0,
    },
    reducers:{
        SET_DATA:(state, action) => {
            state.name = action.payload.name;
            state.weight = action.payload.num;
        },
        SET_CAL:(state, action)=>{
            Math.round(state.calorie = 0.05 * state.weight * action.payload * 60);
        }
    }
})
export const {SET_DATA, SET_CAL} = ResourceSlice.actions;
export default ResourceSlice.reducer;
