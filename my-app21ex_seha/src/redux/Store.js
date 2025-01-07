import {configureStore} from "@reduxjs/toolkit";
import ResourceSlice from "./ResourceSlice";

const Store = configureStore({
    reducer:ResourceSlice,
});
export default Store;